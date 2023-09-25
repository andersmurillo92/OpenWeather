package com.openweather.domain

import com.openweather.data.model.ForecastModel
import com.openweather.data.network.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository){

    companion object {
        private const val TAG = "WeatherUseCase"
    }

    private var result: ForecastModel? = null

    suspend operator fun invoke(): ForecastModel? = try {
        result = weatherRepository.getForecastData()
        result
    } catch (e: Exception){
        result
    }
}