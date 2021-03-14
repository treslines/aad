package com.softsuit.aad.codelab.userinterface.usernavigation.tab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.softsuit.aad.R
import com.softsuit.aad.databinding.FragmentTabHostBinding

class TabHostFragment : Fragment(R.layout.fragment_tab_host) {

    private lateinit var binding: FragmentTabHostBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // another way to bind while you are in the activity instead of fragment
        binding = FragmentTabHostBinding.bind(view)

        // setup tabs
        val tabLayout = binding.tabLayout
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3))

        val pager = binding.pager

        pager.adapter = TabPagerAdapter(tabLayout.tabCount, childFragmentManager)
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
               tab?.let { pager.currentItem = it.position }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
            override fun onTabReselected(tab: TabLayout.Tab?) = Unit
        })
        tabLayout.setupWithViewPager(pager)
    }


}