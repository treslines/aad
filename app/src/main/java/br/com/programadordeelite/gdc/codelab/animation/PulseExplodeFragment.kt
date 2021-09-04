package br.com.programadordeelite.gdc.codelab.animation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.codelab.util.setVisible
import br.com.programadordeelite.gdc.databinding.FragmentPulseExplodeBinding

class PulseExplodeFragment : Fragment(R.layout.fragment_pulse_explode) {
    private lateinit var binding: FragmentPulseExplodeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPulseExplodeBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | LINK PARA AULA: EM ANDAMENTO - JÁ SEGUE O CANLA PARA NÃO PERDER O VÍDEO         |
        // +---------------------------------------------------------------------------------+
    }
}