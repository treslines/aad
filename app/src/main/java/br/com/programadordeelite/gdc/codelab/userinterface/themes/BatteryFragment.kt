package br.com.programadordeelite.gdc.codelab.userinterface.themes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentBatteryBinding

class BatteryFragment : Fragment(R.layout.fragment_battery) {
    private lateinit var binding: FragmentBatteryBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentBatteryBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/JMvXUjISoFo  |
        // +---------------------------------------------------------------------------------+
    }
}