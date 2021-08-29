package br.com.programadordeelite.gdc.codelab.datamanagement.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// METODO DE FABRICA QUE ESPECIFICA COMO CRIAR UM MODELO (ScoreViewModel)
// RAPAZ, EU TU DAVA O SUBSCRIVE AGORA, NA HORA DA PROVA VAI ME AGRADECER! :)
class ScoreViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
