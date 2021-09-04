package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentTabOneBinding

class TabOneFragment (val viewModel: TabViewModel): Fragment(R.layout.fragment_tab_one) {

    private lateinit var binding: FragmentTabOneBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTabOneBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/SGazP_G4ek0  |
        // +---------------------------------------------------------------------------------+
    }
}