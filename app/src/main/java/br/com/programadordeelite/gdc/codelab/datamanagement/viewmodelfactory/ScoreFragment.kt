package br.com.programadordeelite.gdc.codelab.datamanagement.viewmodelfactory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentScoreBinding

class ScoreFragment : Fragment(R.layout.fragment_score) {
    private lateinit var binding: FragmentScoreBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScoreBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}