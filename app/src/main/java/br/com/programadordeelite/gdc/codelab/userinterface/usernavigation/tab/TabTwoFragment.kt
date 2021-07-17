package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentTabTwoBinding

class TabTwoFragment(val viewModel: TabViewModel) : Fragment(R.layout.fragment_tab_two) {

    private lateinit var binding: FragmentTabTwoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTabTwoBinding.bind(view)

        // Criar um observador que atualiza a UI
        val tabContentObserver = Observer<String> { newContent ->
            binding.contentTitle.text = viewModel.getCurrent(newContent)
        }

        viewModel.getContentObserver().observe(viewLifecycleOwner, tabContentObserver)

        binding.btnTabTwo.setOnClickListener {
            viewModel.getContentObserver().setValue("Tab Two!")
        }
    }
}