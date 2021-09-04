package br.com.programadordeelite.gdc.codelab.datamanagement.viewmodelfactory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentTitleBinding

class TitleFragment : Fragment(R.layout.fragment_title) {

    private lateinit var binding: FragmentTitleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTitleBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}