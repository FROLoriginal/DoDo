package com.example.dodo.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.databinding.MenuCardViewBinding
import com.example.dodo.model.Meal

class RecyclerViewHolder(
    private val binding: MenuCardViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(meal: Meal) {
        binding.meal = meal
    }
}
