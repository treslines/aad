package br.com.programadordeelite.gdc

import android.os.Bundle
import android.view.View
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.codelab.util.toast
import br.com.programadordeelite.gdc.databinding.FragmentMainBinding

/** Main Menu Study Guide */
class MainFragment : androidx.fragment.app.Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.codelabNotification.setOnClickListener { navTo(R.id.notificationFragment) }
        binding.codelabToastSnake.setOnClickListener { navTo(R.id.toastSnakeFragment) }
        binding.codelabWorkManager.setOnClickListener { navTo(R.id.selectImageFragment) }
        binding.codelabMaterialComponents.setOnClickListener { navTo(R.id.materialComponentsFragment) }
        binding.codelabInteractiveUi.setOnClickListener { navTo(R.id.interactiveUiFragment) }
        binding.codelabActivitiesIntents.setOnClickListener { navTo(R.id.sendFragment) }
        binding.codelabRecyclerview.setOnClickListener { navTo(R.id.recyclerViewFragment) }
        binding.codelabUserNavigationTab.setOnClickListener { navTo(R.id.tabHostFragment) }
        binding.codelabUserNavigationDrawer.setOnClickListener { navTo(R.id.drawerFragment) }
        binding.codelabMenuPickers.setOnClickListener { navTo(R.id.menuFragment) }
        binding.codelabThemesTouches.setOnClickListener { navTo(R.id.themeFragment) }
        binding.codelabThemesTouchesBaterry.setOnClickListener { navTo(R.id.batteryFragment) }
        binding.codelabRoomWithView.setOnClickListener { navTo(R.id.wordFragment) }
        binding.codelabRoomLivedataViewmodel.setOnClickListener { toast("Visto em: Room with View") }
        binding.codelabRepository.setOnClickListener { toast("Visto em: Room with View") }
        binding.codelabSharedPreferences.setOnClickListener { navTo(R.id.sharedPrefFragment)  }
        binding.codelabAnimPulseExplode.setOnClickListener { navTo(R.id.pulseExplodeFragment)  }
        // +-----------------------------------------------------------------+
        // | Navigation between activities (no fragments for show case)      |
        // +-----------------------------------------------------------------+
        binding.codelabUserNavigation.setOnClickListener { navTo(R.id.showTabsActivity) }
    }
}