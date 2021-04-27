package com.example.dodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dodo.adapters.RecyclerViewAdapter
import com.example.dodo.databinding.PageFragmentBinding
import com.example.dodo.model.Meal


class PageFragment : Fragment() {

     private val userViewModel by lazy { ViewModelProvider(requireActivity()).get(MenuViewModel::class.java) }
     private lateinit var binding: PageFragmentBinding
     private val data = arrayListOf<Meal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.page_fragment, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context).also { it.orientation = LinearLayoutManager.VERTICAL}
        val adapter = RecyclerViewAdapter(data)
        binding.recyclerView.adapter = adapter

        userViewModel.data.observe(requireActivity(), Observer {
            data.addAll(it)
            adapter.notifyDataSetChanged()
        })
        return binding.root
    }
}
