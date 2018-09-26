package com.gdgnairobi.devfest18.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

object BindingAdaptersUtils {

    @BindingAdapter(value = ["image", "placeholderImage", "errorImage"], requireAll = true)
    fun loadImageForView(view: ImageView, imageUrl: String, errorImage: Drawable, placeholderImage: Drawable) {
        Picasso.get().load(imageUrl).placeholder(placeholderImage).error(errorImage).into(view)
    }

    @BindingAdapter("listData")
    fun <T> setListData(view: RecyclerView, data: T) {
        val adapter = view.adapter
        if (adapter is BindableListAdapter<*>) {
            (adapter as BindableListAdapter<T>).setData(data)
        }
    }

    @BindingAdapter("timeString")
    fun setTimeString(view: TextView, date: String) {
        view.text = DateUtils.getPrettifiedTimeString(date)
    }
}