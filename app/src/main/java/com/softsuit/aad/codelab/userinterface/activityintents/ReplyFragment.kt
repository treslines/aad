package com.softsuit.aad.codelab.userinterface.activityintents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.codelab.util.navTo
import com.softsuit.aad.databinding.FragmentReplyBinding

class ReplyFragment : Fragment(R.layout.fragment_reply) {
    private lateinit var binding: FragmentReplyBinding
    private var sent: String? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReplyBinding.bind(view)
        binding.buttonReply.setOnClickListener {
            val args = Bundle()
            args.putString("REPLY",binding.inputReply.text.toString())
            navTo(R.id.action_replyFragment_to_sendFragment, args)
        }
        arguments?.let {
            sent = it.getString("SEND", null)
        }
        sent?.let {
            binding.textMessage.text = it
        }
    }
}