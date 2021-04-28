package com.example.dodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.adapters.RecyclerViewAdapter
import com.example.dodo.databinding.PageFragmentBinding
import com.example.dodo.model.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PageFragment : Fragment() {

    private val mealViewModel by lazy { ViewModelProvider(requireActivity()).get(MenuViewModel::class.java) }
    private lateinit var binding: PageFragmentBinding
     private val data = arrayListOf<Meal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.page_fragment, container, false)
        val adapter = RecyclerViewAdapter(data)
        val manager = LinearLayoutManager(context).also { it.orientation = RecyclerView.VERTICAL }
        binding.recyclerViewAdapter = adapter
        binding.recyclerViewManager = manager
        binding.recyclerViewDecorator = DividerItemDecoration(context, manager.orientation)

        val ingredient = arguments?.getString(INGREDIENT)!!
        mealViewModel.viewModelScope.launch(Dispatchers.Main) {
            mealViewModel.askForMealBy(ingredient)
        }

        mealViewModel.meals.observe(requireActivity(), Observer {
            if (ingredient == it.ingredient) {
                data.addAll(it.meals)
                adapter.notifyDataSetChanged()
            }
        })
        return binding.root
    }

    companion object {
        const val INGREDIENT = "PageFragment_Ingredient"
    }
}
