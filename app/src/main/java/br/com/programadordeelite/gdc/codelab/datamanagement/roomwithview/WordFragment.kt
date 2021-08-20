package br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.programadordeelite.gdc.MainApplication
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview.NewWordFragment.Companion.BUNDLE_KEY_WORD
import br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview.NewWordFragment.Companion.BUNDLE_REQUEST_KEY
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.databinding.FragmentWordBinding

// +-----------------------------------------------------------------+
// | TELA QUE EXIBIRA AS PALAVRAS SALVAS EM NOSSO BANCO DE DADOS     |
// +-----------------------------------------------------------------+
class WordFragment : Fragment(R.layout.fragment_word) {

    private lateinit var binding: FragmentWordBinding

    // OBTER VIEW MODEL ATRAVÉS DE EXTENCÕES DE KOTLIN
    private val wordViewModel: WordViewModel by viewModels {
        // FACTORY CRIA NOSSO MODELO INJETANDO O REPOSITÓRIO QUE CRIAMOS
        WordViewModelFactory((requireActivity().application as MainApplication).repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWordBinding.bind(view)

        val adapter = WordListAdapter()
        binding.recyclerview.adapter = adapter

        // PODE SER DEFINIDO NO XML TAMBEM SE PREFERIR, MAS QUERIA TE MOSTAR MAIS UMA FORMA DE FAZER
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener { navTo(R.id.newWordFragment) }

        wordViewModel.allWords.observe(requireActivity(), { words ->
            // Atualize a cópia em cache das palavras no adaptador.
            words?.let { adapter.submitList(it) }
        })

        // DEFINIR O QUE SERA TETORNADO COMO PARAMETRO, QUANDO ESTA TELA FOR FECHADA
        setFragmentResultListener(BUNDLE_REQUEST_KEY) { _, bundle ->
            val result = bundle.getString(BUNDLE_KEY_WORD, "vazio")
            wordViewModel.insert(Word(result))
        }
    }

}