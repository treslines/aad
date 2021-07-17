package br.com.programadordeelite.gdc.codelab.userinterface.usernavigation.tab

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

// See doc: https://developer.android.com/training/animation/vp2-migration
class TabPagerAdapter2(private val numOfTabs: Int, val host: TabHostFragment) : FragmentStateAdapter(host) {

    override fun getItemCount(): Int = numOfTabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabOneFragment(host.getTabViewModel())
            1 -> TabTwoFragment(host.getTabViewModel())
            2 -> TabThreeFragment(host.getTabViewModel())
            else -> TabOneFragment(host.getTabViewModel())
        }
    }
}