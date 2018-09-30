/*
 *  Copyright (C) 2018 Eton Otieno Oboch
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.gdgnairobi.devfest18.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.gdgnairobi.devfest18.R
import com.gdgnairobi.devfest18.data.model.News
import com.gdgnairobi.devfest18.databinding.ItemLayoutBinding
import com.gdgnairobi.devfest18.utils.BindableListAdapter

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(),
        BindableListAdapter<List<News>> {

    private var newsList = emptyList<News>()

    override fun setData(data: List<News>?) {
        data?.let {
            newsList = it
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = DataBindingUtil.inflate<ItemLayoutBinding>(LayoutInflater.from(parent.context)
                , R.layout.item_layout, parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.news = newsList[position]
    }


    inner class NewsViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}
