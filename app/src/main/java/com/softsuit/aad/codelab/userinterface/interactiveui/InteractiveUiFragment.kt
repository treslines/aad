package com.softsuit.aad.codelab.userinterface.interactiveui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentInteractiveUiBinding
import com.softsuit.aad.databinding.FragmentProductGridBinding

class InteractiveUiFragment : Fragment(R.layout.fragment_interactive_ui) {
    private lateinit var binding: FragmentInteractiveUiBinding
    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInteractiveUiBinding.bind(view)
        binding.showCount.text = count.toString()
        binding.buttonToast.setOnClickListener { showToast() }
        binding.buttonCount.setOnClickListener { countUp(); showCounter() }
    }

    private fun showToast() = Toast.makeText(requireContext(), R.string.toast_message, Toast.LENGTH_SHORT).show()
    private fun countUp() = count++
    private fun showCounter() {
        binding.showCount.text = count.toString()
    }
}