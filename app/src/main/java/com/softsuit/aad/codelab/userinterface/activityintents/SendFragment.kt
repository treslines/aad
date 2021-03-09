package com.softsuit.aad.codelab.userinterface.activityintents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentSendBinding

class SendFragment : Fragment(R.layout.fragment_send) {
    private lateinit var binding: FragmentSendBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendBinding.bind(view)
    }
}