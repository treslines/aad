package com.softsuit.aad.codelab.datamanagement.roomwithview

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentNewWordBinding

class NewWordFragment : Fragment(R.layout.fragment_new_word) {
    private lateinit var binding: FragmentNewWordBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewWordBinding.bind(view)
        binding.buttonSave.setOnClickListener {
            if (TextUtils.isEmpty(binding.editWord.text)) {
                parentFragmentManager.setFragmentResult("requestKey", bundleOf("word" to "empty"))
            } else {
                val word = binding.editWord.text.toString()
                parentFragmentManager.setFragmentResult("requestKey", bundleOf("word" to word))
            }
            findNavController().popBackStack()
        }
    }
}