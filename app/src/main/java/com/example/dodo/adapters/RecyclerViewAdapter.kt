package com.example.dodo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.MenuViewModel
import com.example.dodo.R
import com.example.dodo.databinding.MenuCardViewBinding
import com.example.dodo.model.Meal
import com.example.dodo.viewHolders.RecyclerViewHolder

class RecyclerViewAdapter(private val meals: ArrayList<Meal>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: MenuCardViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.menu_card_view, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount() = meals.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(meals[position])
    }
}
