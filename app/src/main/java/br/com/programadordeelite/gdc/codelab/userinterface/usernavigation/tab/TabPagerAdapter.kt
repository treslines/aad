package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TabPagerAdapter(private val numOfTabs: Int, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = numOfTabs

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabOneFragment()
            1 -> TabTwoFragment()
            2 -> TabThreeFragment()
            else -> TabOneFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}