package br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WordViewModelAndroidTest {

    private lateinit var  wordViewModel: WordViewModel

    @Before
    fun setUp() {

        val factory = WordViewModelFactory(
            MockWordRepository(
                listOf(
                    Word("Ricardo"),
                    Word("Junior")
                )
            )
        )
        wordViewModel = factory.create(WordViewModel::class.java)
    }

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

    @Test
    fun insert_NewWord_IntoViewModel_DispatchesObserver_OnLiveData() {
        wordViewModel.allWords.getOrAwaitTestValue ()

        // Inserir uma nova palavra no banco fake e esperar a conclusão para
        // dar tempo ao liveData de atualizar e notificar o observer
        runBlocking {
            wordViewModel.insert(Word("Nova Palavra"))
        }

        // Ao inserir uma palavra nova, nosso evento é disparado
        val value: List<Word>? = wordViewModel.allWords.value
        assertThat(value?.last(), (not(nullValue())))
        assertThat(value?.last()?.word, (equalTo("Nova Palavra")))
    }
}