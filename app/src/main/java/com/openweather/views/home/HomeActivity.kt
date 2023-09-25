package com.openweather.views.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.openweather.data.model.baseURLImage
import com.openweather.databinding.ActivityHomeBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeView()
    }

    private fun initializeView(){
        initializeObservables()
        viewModel.onCreate()
    }

    @SuppressLint("SetTextI18n")
    private fun initializeObservables(){
        viewModel.forecast.observe(this, Observer {
            it?.let {
                binding.weatherTemp.text = "${it.list[0].main?.temp?.floatToInt().toString()} °F,"
                binding.weatherName.text = it.list[0].weather[0].main.toString()
                binding.weatherBrief.text = it.list[0].weather[0].description.toString()
                Picasso.get().load("$baseURLImage${it.list[0].weather[0].icon}.png").into(binding.weatherIcon)
            }
        })
    }

    private fun String.floatToInt(): Int {
        return this.toFloat().toInt()
    }
}