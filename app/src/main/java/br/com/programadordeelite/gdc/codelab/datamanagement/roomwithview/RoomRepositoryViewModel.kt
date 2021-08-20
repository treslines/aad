package br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.*
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// +----------------------------------------------------------------------+
// | >>> 1° <<< ENTITY: DEFINICÃO DA NOSSA TABELA POR MEIO DE ANOTACÕES   |
// +----------------------------------------------------------------------+
@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)

// +-------------------------------------------------------------------------------------+
// | >>> 2° <<< DAO: DATA ACCESS OBJECT - OBJETO QUE REALIZA OPERACÕES NO BANCO DE DADOS |
// |            ESPECIFICA O QUE PODEREMOS ALTERA NA NOSSA TABELA E FACILITA O USO       |
// +-------------------------------------------------------------------------------------+
@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>> // Note: Estamos usando flow (o video de Paging Lib 3 explica)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table") // que mágica é essa?
    suspend fun deleteAll()
}

// +-----------------------------------------------------------------------------------------------+
// | >>> 3° <<< REPOSITORY: MEDIADOR DE ACESSO A DADOS LOCAIS OU REMOTO CASO EXISTAM VÁRIAS FONTES |
// +-----------------------------------------------------------------------------------------------+
// Declare o DAO como uma propriedade privada no construtor. Passe apenas o DAO
// em vez do banco de dados inteiro, porque você só precisamos acessar o DAO
class WordRepository(private val wordDao: WordDao) {

    // Room executa todas as consultas em um thread separado.
    // Flow observado notificará o observador quando os dados forem alterados.
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    // Por padrão, o Room executa consultas suspensas fora do thread principal, portanto,
    // não precisamos implementar qualquer outra coisa para garantir que não estamos fazendo
    // um trabalho de banco de dados de longa duração fora da Thread principal.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}

// +-----------------------------------------------------------------------+
// | >>> 4° <<< ROOM - NOSSO BANCO DE DADOS COM AS DEFINICÕES DE TABELAS   |
// +-----------------------------------------------------------------------+
@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    // +----------------------------------------------------------------------------------+
    // | CALLBACK - SERA USADA PARA INICIALIZAR O NOSSO BANCO DE DADOS NA HORA DA CRIACÃO |
    // +----------------------------------------------------------------------------------+
    private class WordDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.wordDao()) // SO PARA EXEMPLIFICAR COMO PRE-POPULAR UM BANCO DE DADOS
                }
            }
        }

        suspend fun populateDatabase(wordDao: WordDao) {
            // APAGAMOS TUDO QUE ESTEJA NO BANCO PRIMEIRO (NÃO FACA ISSO EM PRODUCÃO)
            wordDao.deleteAll()

            // ADICIONAMOS ALGUNS VALORES ALEATÓRIOS PARA TER ALGO PARA EXIBIR
            wordDao.insert(Word("Olá, não se esqueça de se inscrever no canal"))
            wordDao.insert(Word("Vai me agradecer na hora da prova! :)"))
        }
    }

    companion object {
        // +------------------------------------------------------------------------------------+
        // | SINGLETON - PREVINE QUE MULTIPLAS INSTANCIAS DO BANCO SEJAM ABERTAS AO MESMO TEMPO |
        // |             PADRÃO DE PROJETO QUE SO DEIXA UMA INSTANCIA DO MESMO OBJETO EXISTIR   |
        // +------------------------------------------------------------------------------------+
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): WordRoomDatabase {
            // SE O BANCO JA EXISTIR, RETORNE DIRETO, DO CONTRÁRIO CRIE O BANCO
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database" // NOME DO NOSSO BANCO DE DADOS
                ).addCallback(WordDatabaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

// +---------------------------------------------------------------------------+
// | >>> 5° <<< VIEW MODEL: ATUALIZAR DADOS E RETEM A LÓGICA DA UI EM QUESTÃO  |
// +---------------------------------------------------------------------------+
class WordViewModel(private val repository: WordRepository) : ViewModel() {

    // Usar LiveData e armazenar em cache o que allWords retorna tem vários benefícios:
    // - Podemos colocar um observador nos dados (em vez de pesquisar as alterações) e apenas
    //   atualizar a IU quando os dados realmente mudam.
    // - O repositório é completamente separado da IU por meio do ViewModel.
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /** Lançamento de uma nova co-rotina para inserir os dados de forma não bloqueadora */
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

// +---------------------------------------------------------+
// | >>> 6° <<< MODEL FACTORY: CRIADOR DE OBJETOS COMPLEXOS  |
// +---------------------------------------------------------+
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) return WordViewModel(repository) as T
        throw IllegalArgumentException("MODELO DESCONHECIDO")
    }
}