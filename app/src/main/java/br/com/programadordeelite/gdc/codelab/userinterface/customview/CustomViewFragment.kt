package br.com.programadordeelite.gdc.codelab.userinterface.customview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.snake
import br.com.programadordeelite.gdc.databinding.FragmentCustomViewBinding
import br.com.programadordeelite.gdc.databinding.FragmentReplyBinding

class CustomViewFragment : Fragment(R.layout.fragment_custom_view) {

    private lateinit var binding: FragmentCustomViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCustomViewBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/fpNEife2cYo  |
        // +---------------------------------------------------------------------------------+
    }
}