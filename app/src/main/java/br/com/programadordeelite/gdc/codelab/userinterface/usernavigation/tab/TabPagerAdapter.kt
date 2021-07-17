package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

// OLD school implementation
class TabPagerAdapter(private val numOfTabs: Int, private val tabViewModel: TabViewModel, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = numOfTabs

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabOneFragment(tabViewModel)
            1 -> TabTwoFragment(tabViewModel)
            2 -> TabThreeFragment(tabViewModel)
            else -> TabOneFragment(tabViewModel)
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}