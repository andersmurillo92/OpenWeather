package com.openweather.views.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.openweather.data.model.ForecastModel
import com.openweather.data.model.ThreeHoursDataModel
import com.openweather.data.model.baseURLImage
import com.openweather.databinding.ActivityHomeBinding
import com.openweather.views.home.adapter.DayForecastedAdapter
import com.openweather.views.interfaces.ItemActionListener
import com.openweather.views.interfaces.UIBehavior
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: AppCompatActivity(), UIBehavior, UIBehavior.RecyclerView, ItemActionListener {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val dayForecastedAdapter = DayForecastedAdapter(this)
    lateinit var chunkedList : List<List<ThreeHoursDataModel>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeUI()
    }

    @SuppressLint("SetTextI18n")
    private fun initializeObservables(){
        viewModel.isLoading.observe(this) {
            if (!it) binding.progressBar.visibility = View.GONE
        }

        viewModel.forecast.observe(this) {
            it?.let {
                binding.weatherTemp.text = "${it.list[0].main?.temp?.floatToInt().toString()} °F,"
                binding.weatherName.text = it.list[0].weather[0].main.toString()
                binding.weatherBrief.text = it.list[0].weather[0].description.toString()
                Picasso.get().load("$baseURLImage${it.list[0].weather[0].icon}.png")
                    .into(binding.weatherIcon)

                chunkedList = it.list.chunked(8)
                dayForecastedAdapter.onUpdateData(chunkedList)
            }
        }
    }

    override fun initializeUI() {
        initializeRecyclerView()
        initializeObservables()
        viewModel.onCreate()
    }

    override fun initializeRecyclerView() {
        with(binding) {
            daysForecasted.layoutManager =
                LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            daysForecasted.adapter = dayForecastedAdapter
        }
    }

    override fun onClickItem(item: Any, position: Int) {
        // TODO("Not yet implemented")
    }

    private fun String.floatToInt(): Int {
        return this.toFloat().toInt()
    }
}