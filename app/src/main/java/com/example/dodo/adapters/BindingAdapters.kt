package com.example.dodo.adapters

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("setImageUrl")
fun ImageView.bindImageUrl(url: String?) {

    if (!url.isNullOrBlank()) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .centerCrop()
            .into(this)
    }
}

@BindingAdapter("setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>){
    this.adapter = adapter
    setHasFixedSize(true)
}

@BindingAdapter("setManager")
fun RecyclerView.bindRecyclerViewOrientation(manager: LinearLayoutManager){
    layoutManager = manager
}

@BindingAdapter("setDecorator")
fun RecyclerView.bindRecyclerViewDecorator(decoration: DividerItemDecoration){
    addItemDecoration(decoration)
}
