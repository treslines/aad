package br.com.programadordeelite.gdc.codelab.userinterface.recyclerview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.startAnimation
import br.com.programadordeelite.gdc.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    private lateinit var binding: FragmentRecyclerViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecyclerViewBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/Da3PCGnIagE  |
        // +---------------------------------------------------------------------------------+
    }
}