package com.gdgnairobi.devfest18.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gdgnairobi.devfest18.data.NewsRepository
import com.gdgnairobi.devfest18.data.model.News

class MainViewModel : ViewModel() {

    private val repository = NewsRepository()
    val news: LiveData<List<News>>
        get() = repository.newsList
}
