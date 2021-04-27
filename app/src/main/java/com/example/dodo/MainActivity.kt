package com.example.dodo

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.dodo.adapters.FragmentPageAdapter
import com.example.dodo.adapters.HardCodeRecyclerViewAdapter
import com.example.dodo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mealViewModel by lazy { ViewModelProvider(this).get(MenuViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = mealViewModel
        binding.recyclerViewAdapter = HardCodeRecyclerViewAdapter()
        binding.pager.adapter = FragmentPageAdapter(this)
        binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        mealViewModel.data.observe(this, Observer {})
        setupViewPager()
    }

    private fun setupViewPager() {

        TabLayoutMediator(binding.tabLayout, binding.pager) { currentTab, currentPosition ->
            currentTab.text = currentPosition.toString()
        }.attach()

    }

}
