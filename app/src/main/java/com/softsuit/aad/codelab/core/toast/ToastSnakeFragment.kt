package com.softsuit.aad.codelab.core.toast

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentToastSnakeBinding

class ToastSnakeFragment : Fragment(R.layout.fragment_toast_snake) {

    private lateinit var binding: FragmentToastSnakeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentToastSnakeBinding.bind(view)

        binding.toast.setOnClickListener {
            Toast.makeText(requireContext(), "Minha mensagem para você!", Toast.LENGTH_SHORT).show()
        }

        binding.snake.setOnClickListener {
            Snackbar.make(view, "Oi Snake", Snackbar.LENGTH_SHORT).show()
        }
    }
}