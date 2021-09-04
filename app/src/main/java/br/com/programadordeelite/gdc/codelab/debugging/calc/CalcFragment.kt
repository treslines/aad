package br.com.programadordeelite.gdc.codelab.debugging.calc

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentCalcBinding
import timber.log.Timber
import java.lang.IllegalArgumentException

// LINK PARA VC SE APROFUNDAR NOS ESTUDOS
// https://developer.android.com/studio/command-line/adb.html
class CalcFragment : Fragment(R.layout.fragment_calc) {

    private lateinit var binding: FragmentCalcBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalcBinding.bind(view)
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}