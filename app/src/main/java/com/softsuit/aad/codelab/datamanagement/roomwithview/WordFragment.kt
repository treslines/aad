package com.softsuit.aad.codelab.datamanagement.roomwithview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsuit.aad.MainApplication
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentWordBinding

class WordFragment : Fragment(R.layout.fragment_word) {

    private lateinit var binding: FragmentWordBinding
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((requireActivity().application as MainApplication).repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWordBinding.bind(view)
        val adapter = WordListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.newWordFragment)
        }

        wordViewModel.allWords.observe(requireActivity(), { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.submitList(it) }
        })

        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getString("word", "empty")
            wordViewModel.insert(Word(result))
        }
    }

}