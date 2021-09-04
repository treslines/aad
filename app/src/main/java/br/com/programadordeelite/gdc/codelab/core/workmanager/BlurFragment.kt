package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.WorkInfo
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentBlurBinding
import com.bumptech.glide.Glide

class BlurFragment : Fragment(R.layout.fragment_blur) {

    private lateinit var viewModel: BlurViewModel
    private lateinit var binding: FragmentBlurBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlurBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA AS AULAS:                             |
        // | https://youtu.be/5AGWzq9JpYo                                                    |
        // | https://youtu.be/MJpeoRopmgw                                                    |
        // | https://youtu.be/vGwr9XZ8xDY                                                    |
        // +---------------------------------------------------------------------------------+
    }
}