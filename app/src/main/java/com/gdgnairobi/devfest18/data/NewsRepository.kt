package com.gdgnairobi.devfest18.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gdgnairobi.devfest18.data.guardian.GuardianMain
import com.gdgnairobi.devfest18.data.guardian.mapToNewsModel
import com.gdgnairobi.devfest18.data.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class NewsRepository {

    companion object {
        private const val BASE_URL = " https://content.guardianapis.com/"
    }

    private val _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>>
        get() = _newsList


    private val retrofit: Retrofit =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    private val newsService: NewsService = retrofit.create(NewsService::class.java)

    init {
        newsService.getNews().enqueue(object : Callback<GuardianMain> {
            override fun onResponse(call: Call<GuardianMain>, response: Response<GuardianMain>) {
                if (response.isSuccessful) {
                    Timber.d(" NewsResponse is successful")
                    _newsList.postValue(response.body()?.mapToNewsModel())
                }
            }

            override fun onFailure(call1: Call<GuardianMain>, throwable: Throwable) {
                Timber.e(throwable)
            }
        })

    }
}