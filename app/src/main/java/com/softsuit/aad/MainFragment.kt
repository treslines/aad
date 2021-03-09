package com.softsuit.aad

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.softsuit.aad.codelab.util.navTo
import com.softsuit.aad.databinding.FragmentMainBinding

/** Main Menu Study Guide */
class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.codelabNotification.setOnClickListener { navTo(R.id.notificationFragment) }
        binding.codelabToastSnake.setOnClickListener { navTo(R.id.toastSnakeFragment) }
        binding.codelabWorkManager.setOnClickListener { navTo(R.id.selectImageFragment) }
        binding.codelabMaterialComponents.setOnClickListener { navTo(R.id.materialComponentsFragment) }
        binding.codelabInteractiveUi.setOnClickListener { navTo(R.id.interactiveUiFragment) }
    }
}