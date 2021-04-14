package br.com.programadordeelite.gdc.codelab.core.toast

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentToastSnakeBinding
import com.google.android.material.snackbar.Snackbar

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
