package br.com.programadordeelite.gdc

import android.app.Application
import br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview.WordRepository
import br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber

class MainApplication : Application() {

    // NÃO HÁ NECESSIDADE DE CANCELAR ESTE ESCOPO, POIS ELE SERÁ DESTRUÍDO COM O PROCESSO
    private val applicationScope = CoroutineScope(SupervisorJob())

    // CRIACAO DO NOSSO BANCO DE DADOS LAZY (SO SERA INSTANCIADO QUANDO FOR USADO PELA PRIMEIRA VEZ)
    private val database by lazy { WordRoomDatabase.getDatabase(this@MainApplication, applicationScope) }

    // DEFINICAO DO NOSSO REPOSITORIO A NIVEL DE APLICACAO PARA FICAR DISPONIVEL EM TODOS OS LUGARES
    val repository by lazy { WordRepository(database.wordDao()) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // Timber é o "novo" Logger recomendado pela google
            Timber.plant(Timber.DebugTree())
        }
    }
}