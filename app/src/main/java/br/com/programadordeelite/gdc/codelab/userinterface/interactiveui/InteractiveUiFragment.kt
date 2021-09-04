package br.com.programadordeelite.gdc.codelab.userinterface.interactiveui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentInteractiveUiBinding

class InteractiveUiFragment : Fragment(R.layout.fragment_interactive_ui) {
    private lateinit var binding: FragmentInteractiveUiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInteractiveUiBinding.bind(view)
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/XBUbvKczRRI  |
        // +---------------------------------------------------------------------------------+
    }
}