package br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentNewWordBinding

// +-----------------------------------------------------------------+
// | TELA QUE CADASTRARÁ NOVAS PALAVRAS NO NOSSO BANCO DE DADOS      |
// +-----------------------------------------------------------------+
class NewWordFragment : Fragment(R.layout.fragment_new_word) {
    private lateinit var binding: FragmentNewWordBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewWordBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}