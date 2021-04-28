package com.example.dodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.dodo.adapters.FragmentPageAdapter
import com.example.dodo.adapters.HardCodeRecyclerViewAdapter
import com.example.dodo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mealViewModel by lazy { ViewModelProvider(this).get(MenuViewModel::class.java) }

    private val ingredients = hashMapOf(
        0 to "chicken_breast", 1 to "oil",
        2 to "carrot", 3 to "banana",
        4 to "water"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = mealViewModel
        binding.recyclerViewAdapter = HardCodeRecyclerViewAdapter()
        binding.recyclerViewManager =
            LinearLayoutManager(this).also { it.orientation = RecyclerView.HORIZONTAL }
        binding.pager.adapter = FragmentPageAdapter(this, ingredients)
        binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        setupViewPager()
    }

    private fun setupViewPager() {

        TabLayoutMediator(binding.tabLayout, binding.pager) { currentTab, currentPosition ->
            currentTab.text = ingredients[currentPosition]?.toRus()
        }.attach()

    }

    private fun String.toRus() = when(this){
        "chicken_breast" -> "Курица"
        "oil" -> "Масло"
        "carrot" -> "Морковь"
        "banana" -> "Банан"
        "water" -> "Вода"
        else -> "Что-то необычное"
    }

}
