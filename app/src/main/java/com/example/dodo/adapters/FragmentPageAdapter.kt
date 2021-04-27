package com.example.dodo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dodo.PageFragment

class FragmentPageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 1

    override fun createFragment(position: Int): Fragment {
        return PageFragment()
    }
}
