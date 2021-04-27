package com.example.dodo.viewHolders

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dodo.databinding.ActivityMainBinding
import com.example.dodo.databinding.HardCodeCardViewBinding

class HardCodeViewHolder(private val binder: HardCodeCardViewBinding) :
    RecyclerView.ViewHolder(binder.root) {

    fun bind(image: Drawable) {

        binder.imageView2.setImageDrawable(image)
    }

}
