package br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentWordBinding

// +-----------------------------------------------------------------+
// | TELA QUE EXIBIRA AS PALAVRAS SALVAS EM NOSSO BANCO DE DADOS     |
// +-----------------------------------------------------------------+
class WordFragment : Fragment(R.layout.fragment_word) {

    private lateinit var binding: FragmentWordBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWordBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }

}