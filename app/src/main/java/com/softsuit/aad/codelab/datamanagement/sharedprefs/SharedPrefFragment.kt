package com.softsuit.aad.codelab.datamanagement.sharedprefs

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentSharedPrefBinding


class SharedPrefFragment : Fragment(R.layout.fragment_shared_pref) {

    private val COUNT_KEY = "COUNT_KEY"
    private val COLOR_KEY = "COLOR_KEY"
    private var mCount = 0
    private var mColor = 0
    private var mPreferences: SharedPreferences? = null
    private val sharedPrefFile = "com.example.android.hellosharedprefs"

    private lateinit var binding: FragmentSharedPrefBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.getInt(COUNT_KEY)?.let {
            mCount = it
        }
        if (mCount != 0) {
            //mShowCountTextView.setText(String.format("%s", mCount));
        }
        savedInstanceState?.getInt(COLOR_KEY)?.let {
            mColor = it
        }


        binding = FragmentSharedPrefBinding.bind(view)
        mPreferences = requireActivity().getSharedPreferences(sharedPrefFile, MODE_PRIVATE)

    }

    override fun onPause() {
        super.onPause()
        mPreferences?.let {
            val editor = it.edit()
            editor.putInt(COUNT_KEY, mCount)
            editor.putInt(COLOR_KEY, mColor)
            editor.apply()
        }
    }

    fun reset(view: View) {
        // Reset count
        mCount = 0;
        //mShowCountTextView.setText(String.format("%s", mCount))

        // Reset color
        //mColor = requireContext().getColor(requireContext(), R.color.buttonLabel)
        //mShowCountTextView.setBackgroundColor(mColor);

        mPreferences?.let {
            val editor = it.edit()
            editor.clear()
            editor.apply()
        }
    }
}