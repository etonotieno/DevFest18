package com.gdgnairobi.devfest18.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdgnairobi.devfest18.R
import com.gdgnairobi.devfest18.databinding.MainActivityBinding
import net.danlew.android.joda.JodaTimeAndroid

class MainActivity : AppCompatActivity() {

    private val newsViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val mainBinding: MainActivityBinding  by lazy {
        DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JodaTimeAndroid.init(this)
        mainBinding.viewModel = newsViewModel
        mainBinding.setLifecycleOwner(this)

        mainBinding.mainActivityRecyclerView.apply {
            adapter = NewsAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

}
