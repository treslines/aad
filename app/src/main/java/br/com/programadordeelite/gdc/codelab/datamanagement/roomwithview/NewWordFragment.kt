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

    companion object {
        const val BUNDLE_KEY_WORD = "word"
        const val BUNDLE_REQUEST_KEY = "requestKey"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewWordBinding.bind(view)

        binding.buttonSave.setOnClickListener {
            // BOM SABER QUE EXISTE ESSA CLASSE UTILITÁRIA PARA MANIPULAR OU VALIDAR STRINGS
            if (TextUtils.isEmpty(binding.editWord.text)) {
                parentFragmentManager.setFragmentResult(BUNDLE_REQUEST_KEY, bundleOf(BUNDLE_KEY_WORD to "vazio"))
            } else {
                val word = binding.editWord.text.toString()
                parentFragmentManager.setFragmentResult(BUNDLE_REQUEST_KEY, bundleOf(BUNDLE_KEY_WORD to word))
            }
            // NAVEGA PARA A TELA ANTERIOR - FUNCÃO ANALOGICA AO BOTÃO DE BACK
            findNavController().popBackStack()
        }
    }
}