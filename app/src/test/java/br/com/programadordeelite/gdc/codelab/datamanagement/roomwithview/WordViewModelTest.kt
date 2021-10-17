package br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WordViewModelTest {

    private lateinit var wordViewModel: WordViewModel

    // Esta regra executa todos os trabalhos de segundo plano relacionados aos componentes
    // de arquitetura na mesma Thread para que os resultados do teste ocorram de forma
    // síncrona e em uma ordem repetível. Ao escrever testes que incluem o teste LiveData,
    // use esta regra!
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // LiveData são objetos observáveis. Nossos modelos em algum momento dentro dos Fragments
    // ou activites observam estas mudanças. Exemplo: Dentro do WordFragment vemos isso aqui:
    // wordViewModel.allWords.observe(requireActivity(), { words ->
    //   words?.let { adapter.submitList(it) }
    // })
    //
    // Nosso ViewModel no entanto ainda não observa nada. Então nao teríamos como testa-lo.
    // Para isso temos que passar a observar o liveData criando um observer que não faz nada
    // e adiciona-lo ao liveData dentro do nosso viewModel.

    @Before
    fun setUp() {
        val initialWords = listOf(
            Word("Ricardo"),
            Word("Junior")
        )
        // Aqui é onde mockamos os dados uando nosso repositório fake
        val factory = WordViewModelFactory(MockWordRepository(initialWords))
        wordViewModel = factory.create(WordViewModel::class.java)
    }

    @Test
    fun insert_NewWord_IntoViewModel_DispatchesObserver_OnLiveData() {
        wordViewModel.allWords.getOrAwaitValue()

        // Inserir uma nova palavra no banco fake e esperar a conclusão para
        // dar tempo ao liveData de atualizar e notificar o observer
        runBlocking {
            wordViewModel.insert(Word("Nova Palavra"))
        }

        // Ao inserir uma palavra nova, nosso evento é disparado
        val value: List<Word>? = wordViewModel.allWords.value
        assertNotNull(value?.last())
        assertEquals(value?.last()?.word, "Nova Palavra")
    }
}