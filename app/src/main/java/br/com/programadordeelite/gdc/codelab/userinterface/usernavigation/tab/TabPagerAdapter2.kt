package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// See doc: https://developer.android.com/training/animation/vp2-migration
class TabPagerAdapter2(private val numOfTabs: Int, fm: Fragment) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = numOfTabs
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabOneFragment()
            1 -> TabTwoFragment()
            2 -> TabThreeFragment()
            else -> TabOneFragment()
        }
    }
}