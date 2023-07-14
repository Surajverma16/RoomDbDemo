package com.example.roomdbdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager, var tabcount: Int) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AllUserFragment()
            1 -> Above50Users()
            else -> AllUserFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "All Users"
            1 -> "Users Above Age 50"
            else -> " All Users"
        }
    }
}