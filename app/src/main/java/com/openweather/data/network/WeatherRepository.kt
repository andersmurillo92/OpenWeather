package com.openweather.data.network

import android.util.Log
import com.openweather.data.model.ForecastModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val WeatherService: WeatherService) {

    companion object {
        private const val TAG = "----- WeatherRepository -----"
    }

    suspend fun getForecastData(): ForecastModel =
        withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "Method Called: getForecastData()")
                val result: ForecastModel = WeatherService.getWeatherData()
                Log.i(TAG, "$result")
                result
            } catch (e: Exception) {
                Log.i(TAG, "Exception: $e")
                ForecastModel(emptyList())
            }
        }
}