package br.com.programadordeelite.gdc.codelab.datamanagement.sharedprefs

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
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
    @ColorRes private var mColor = R.color.black_text_color
    private val mPreferences: SharedPreferences by lazy { requireActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE) }

    private lateinit var binding: FragmentSharedPrefBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSharedPrefBinding.bind(view)

        mPreferences.getInt(COUNT_KEY, 0).let { mCount = it }
        mPreferences.getInt(COLOR_KEY, 0).let { mColor = it }

        if (mCount != 0) binding.countText.text = String.format("%s", mCount)
        if (mColor != 0) binding.countText.setTextColor(getColorFromResourceId(mColor))

        binding.reset.setOnClickListener { reset() }
        binding.blackButton.setOnClickListener {
            mColor = R.color.design_default_color_on_secondary
            updateUi(R.color.design_default_color_on_secondary)
        }

        binding.greenButton.setOnClickListener {
            mColor = R.color.design_default_color_secondary
            updateUi(R.color.design_default_color_secondary)
        }

        binding.blueButton.setOnClickListener {
            mColor = R.color.titleColor
            updateUi(R.color.titleColor)
        }

        binding.redButton.setOnClickListener {
            mColor = R.color.design_default_color_error
            updateUi(R.color.design_default_color_error)
        }
        binding.count.setOnClickListener {
            binding.countText.text = (++mCount).toString()
        }
    }

    private fun updateUi(@ColorRes colorId: Int) {
        binding.countText.setTextColor(getColorFromResourceId(colorId))
    }

    override fun onPause() {
        super.onPause()
        // NA HORA DO "APERREIO" DA PROVA, DA UM SWITCH PRA CÁ, LEMBRA E VOLTA! :)
        mPreferences.let {
            val editor = it.edit()
            editor.putInt(COUNT_KEY, mCount)
            editor.putInt(COLOR_KEY, mColor)
            editor.apply()
        }
    }

    private fun reset() {
        mCount = 0
        binding.countText.text = String.format("%s", mCount)

        mColor = android.R.color.white
        binding.countText.setBackgroundColor(getColorFromResourceId(mColor))

        // NA HORA DO "APERREIO" DA PROVA, DA UM SWITCH PRA CÁ, LEMBRA E VOLTA! :)
        mPreferences.let {
            val editor = it.edit()
            editor.clear()
            editor.apply()
        }
    }

    private fun getColorFromResourceId(@ColorRes colorId: Int) : Int {
        return if(colorId != 0) requireContext().getColor(colorId) else R.color.black_text_color
    }
}