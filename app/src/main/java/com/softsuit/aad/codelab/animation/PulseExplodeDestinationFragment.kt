package com.softsuit.aad.codelab.animation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.codelab.util.setVisible
import com.softsuit.aad.databinding.FragmentPulseExplodeBinding
import com.softsuit.aad.databinding.FragmentPulseExplodeDestinationBinding

class PulseExplodeDestinationFragment : Fragment(R.layout.fragment_pulse_explode_destination) {

    private lateinit var binding: FragmentPulseExplodeDestinationBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPulseExplodeDestinationBinding.bind(view)
    }
}