package br.com.programadordeelite.gdc.codelab.animation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentPulseExplodeDestinationBinding

class PulseExplodeDestinationFragment : Fragment(R.layout.fragment_pulse_explode_destination) {

    private lateinit var binding: FragmentPulseExplodeDestinationBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPulseExplodeDestinationBinding.bind(view)
    }
}