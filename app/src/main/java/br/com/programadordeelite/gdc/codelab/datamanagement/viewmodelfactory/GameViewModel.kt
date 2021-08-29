package br.com.programadordeelite.gdc.codelab.datamanagement.viewmodelfactory

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {
    // a palavra atual, inicialmente vazia
    var word = ""

    // o placar atual de pontuação
    var score = 0

    // lista de palavras que devem ser advinhadas
    private lateinit var wordList: MutableList<String>

    /**
     * Reseta a lista de palavras e randomiza a ordem delas
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen", "hospital", "basketball", "cat",
            "change", "snail", "soup", "calendar",
            "sad", "desk", "guitar", "home",
            "railway", "zebra", "jelly", "car",
            "crow", "trade", "bag", "roll", "bubble"
        )
        wordList.shuffle()
    }

    init {
        Timber.i("GameViewModel created!")
        resetList()
        nextWord()
    }

    /** Callback called when the ViewModel is destroyed */
    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed!")
    }

    /** metodos para atualizar a UI **/
    fun onSkip() { score--; nextWord() }
    fun onCorrect() { score++; nextWord() }

    /** Move para a proxima palavra na lista.*/
    private fun nextWord() {
        // Seleciona e remove a palavra da lista
        if (wordList.isNotEmpty()) {
            word = wordList.removeAt(0)
        }
    }
}
