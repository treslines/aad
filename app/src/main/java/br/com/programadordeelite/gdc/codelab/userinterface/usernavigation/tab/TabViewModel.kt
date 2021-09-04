package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TabViewModel : ViewModel() {

    var currentTabContent: String = "Current on Tab One!"
    var currentTab: String = "Tab One!"
    private val currentTabObserver: MutableLiveData<String> = MutableLiveData()

    // lógica é programada no view model a view geralmente so é atualizada
    // separando responsabilidades CoC (cerparation of concern)
    fun getCurrent(tab: String): String {
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/SGazP_G4ek0  |
        // +---------------------------------------------------------------------------------+
        return currentTabContent
    }

    fun getContentObserver(): MutableLiveData<String> = currentTabObserver
}