package com.openweather.domain

import android.content.Context
import com.openweather.data.model.ForecastResponseModel
import com.openweather.data.network.WeatherRepository
import com.openweather.utils.NetworkChecker
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository,
                                         private val networkChecker: NetworkChecker,
                                         private val context: Context){

    companion object {
        private const val TAG = "WeatherUseCase"
    }

    private var result: ForecastResponseModel? = null

    suspend operator fun invoke(): ForecastResponseModel? = try {
        if(networkChecker.isOnline(context)){
            result = weatherRepository.getForecastData()
            result
        } else {
            result
        }
    } catch (e: Exception){
        result
    }
}