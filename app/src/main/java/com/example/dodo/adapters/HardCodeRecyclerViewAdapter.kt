package com.example.dodo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dodo.R
import com.example.dodo.databinding.HardCodeCardViewBinding
import com.example.dodo.viewHolders.HardCodeViewHolder

class HardCodeRecyclerViewAdapter: RecyclerView.Adapter<HardCodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HardCodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: HardCodeCardViewBinding =
            DataBindingUtil.inflate(inflater,R.layout.hard_code_card_view,parent,false)
        return HardCodeViewHolder(binding)
    }

    override fun getItemCount() = 5

    override fun onBindViewHolder(holder: HardCodeViewHolder, position: Int) {
        val drawable =  ResourcesCompat.getDrawable(holder.itemView.resources,R.mipmap.hard_code_banner,null)
        holder.bind(drawable!!)
    }
}
