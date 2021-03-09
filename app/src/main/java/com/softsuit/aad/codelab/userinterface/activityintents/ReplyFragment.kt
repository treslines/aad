package com.softsuit.aad.codelab.userinterface.activityintents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentReplyBinding

class ReplyFragment : Fragment(R.layout.fragment_reply) {
    private lateinit var binding: FragmentReplyBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReplyBinding.bind(view)
    }
}