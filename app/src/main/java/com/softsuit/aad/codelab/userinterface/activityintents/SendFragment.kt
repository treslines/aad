package com.softsuit.aad.codelab.userinterface.activityintents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.softsuit.aad.R
import com.softsuit.aad.codelab.util.navTo
import com.softsuit.aad.databinding.FragmentSendBinding

class SendFragment : Fragment(R.layout.fragment_send) {
    private lateinit var binding: FragmentSendBinding
    private var reply: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendBinding.bind(view)
        binding.buttonSend.setOnClickListener {
            val args = Bundle()
            args.putString("SEND",binding.inputSend.text.toString())
            navTo(R.id.action_sendFragment_to_replyFragment, args)
        }

        arguments?.let {
            reply = it.getString("REPLY", null)
        }
        reply?.let {
            binding.textMessage.text = it
        }
    }
}