
package com.example.dodo.viewHolders

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.databinding.HardCodeCardViewBinding

class HardCodeViewHolder(private val binder: HardCodeCardViewBinding) :
    RecyclerView.ViewHolder(binder.root) {

    fun bind(image: Drawable) {

        binder.imageView2.setImageDrawable(image)
    }

}
