package com.example.dodo.adapters

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dodo.PageFragment

class FragmentPageAdapter(
    fa: FragmentActivity,
    private val ingredients: HashMap<Int, String>
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = ingredients.size

    override fun createFragment(position: Int): Fragment {

        return PageFragment().apply {
            arguments = bundleOf(Pair(PageFragment.INGREDIENT, ingredients[position]))
        }
    }

}
