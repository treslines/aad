package br.com.programadordeelite.gdc.codelab.datamanagement.sharedprefs

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentSharedPrefBinding


class SharedPrefFragment : Fragment(R.layout.fragment_shared_pref) {

    companion object {
        const val COUNT_KEY = "COUNT_KEY"
        const val COLOR_KEY = "COLOR_KEY"
        const val SHARED_PREFS = "com.softsuit.codelab.datamanagement.sharedprefs"
    }

    private var mCount = 0
    private var mColor = 0
    private var mPreferences: SharedPreferences? = null


    private lateinit var binding: FragmentSharedPrefBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSharedPrefBinding.bind(view)

        mPreferences = requireActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        mPreferences?.getInt(COUNT_KEY, 0)?.let { mCount = it }
        mPreferences?.getInt(COLOR_KEY, 0)?.let { mColor = it }
        if (mCount != 0) {
            binding.countText.text = String.format("%s", mCount)
        }
        if (mColor != 0) {
            binding.countText.setTextColor(requireContext().getColor(mColor))
        }
        binding.reset.setOnClickListener { reset() }
        binding.blackButton.setOnClickListener {
            mColor = R.color.design_default_color_on_secondary
            updateUi(requireContext().getColor(R.color.design_default_color_on_secondary))
        }
        binding.greenButton.setOnClickListener {
            mColor = R.color.design_default_color_secondary
            updateUi(requireContext().getColor(R.color.design_default_color_secondary))
        }
        binding.blueButton.setOnClickListener {
            mColor = R.color.design_default_color_primary
            updateUi(requireContext().getColor(R.color.design_default_color_primary))
        }
        binding.redButton.setOnClickListener {
            mColor = R.color.design_default_color_error
            updateUi(requireContext().getColor(R.color.design_default_color_error))
        }
        binding.count.setOnClickListener {
            binding.countText.text = (++mCount).toString()
        }
    }

    private fun updateUi(color: Int) {
        binding.countText.setTextColor(color)
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

    private fun reset() {
        mCount = 0
        binding.countText.text = String.format("%s", mCount)

        mColor = 0
        binding.countText.setBackgroundColor(mColor)

        mPreferences?.let {
            val editor = it.edit()
            editor.clear()
            editor.apply()
        }
    }
}