package com.softsuit.aad.codelab.userinterface.themes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.codelab.userinterface.menu.DatePickerFragment
import com.softsuit.aad.codelab.userinterface.menu.TimePickerFragment
import com.softsuit.aad.codelab.util.toast
import com.softsuit.aad.databinding.FragmentBatteryBinding
import com.softsuit.aad.databinding.FragmentOrderBinding

class BatteryFragment : Fragment(R.layout.fragment_battery) {
    private lateinit var binding: FragmentBatteryBinding

    private var imageLevel = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBatteryBinding.bind(view)
        binding.minusButton.setOnClickListener {
            --imageLevel
            if (imageLevel < 0) imageLevel = 0
            binding.batteryLevelImage.setImageLevel(imageLevel)
        }
        binding.plusButton.setOnClickListener {
            ++imageLevel
            if (imageLevel > 4) imageLevel = 4
            binding.batteryLevelImage.setImageLevel(imageLevel)
        }
    }
}