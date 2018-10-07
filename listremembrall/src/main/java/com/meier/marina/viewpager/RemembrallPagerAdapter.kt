package com.meier.marina.viewpager

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.meier.marina.listremembrall.R
import com.meier.marina.listremembrall.RemembrallListFragment

internal class RemembrallPagerAdapter(
    fm: FragmentManager,
    private val res: Resources
) : FragmentStatePagerAdapter(fm) {

    private val idTitles = arrayOf(R.string.upcoming, R.string.history)

    override fun getCount(): Int = idTitles.size

    override fun getItem(i: Int): Fragment {
        return RemembrallListFragment.newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return res.getString(idTitles[position])
    }
}
