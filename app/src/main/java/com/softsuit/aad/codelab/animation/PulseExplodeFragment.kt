package com.softsuit.aad.codelab.animation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentPulseExplodeBinding

class PulseExplodeFragment : Fragment(R.layout.fragment_pulse_explode) {
    private lateinit var binding: FragmentPulseExplodeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPulseExplodeBinding.bind(view)

    }
}