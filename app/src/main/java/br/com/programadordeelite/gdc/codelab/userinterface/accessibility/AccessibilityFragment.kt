package br.com.programadordeelite.gdc.codelab.userinterface.accessibility

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentAccessibilityBinding
import br.com.programadordeelite.gdc.databinding.FragmentInteractiveUiBinding

class AccessibilityFragment : Fragment(R.layout.fragment_accessibility) {
    private lateinit var binding: FragmentAccessibilityBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccessibilityBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/riAGnGv5aAs  |
        // +---------------------------------------------------------------------------------+
    }
}