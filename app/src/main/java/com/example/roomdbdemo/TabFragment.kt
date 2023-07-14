package com.example.roomdbdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdbdemo.databinding.FragmentTabBinding


class TabFragment : Fragment() {

lateinit var binding: FragmentTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter =ViewPagerAdapter(childFragmentManager,2)
        binding.viewPager.offscreenPageLimit = 2

        binding.tabLayout.setScrollPosition(0,0f, true)
        binding.viewPager.setCurrentItem(0)

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}