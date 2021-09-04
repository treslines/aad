package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentTabHostBinding
import com.google.android.material.tabs.TabLayoutMediator

// See doc: https://developer.android.com/training/animation/vp2-migration
// See doc: https://developer.android.com/topic/libraries/architecture/livedata
class TabHostFragment : Fragment(R.layout.fragment_tab_host) {

    private lateinit var binding: FragmentTabHostBinding
    private val viewModel: TabViewModel by viewModels()

    // Outra maneira de definir o view model
    // private lateinit var viewModel: TabViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = FragmentTabHostBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/SGazP_G4ek0  |
        // +---------------------------------------------------------------------------------+
    }

    fun getTabViewModel(): TabViewModel = viewModel
}