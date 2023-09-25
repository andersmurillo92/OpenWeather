package com.openweather.data.network

import android.util.Log
import com.openweather.data.model.ForecastResponseModel
import retrofit2.Response
import javax.inject.Inject

class WeatherService @Inject constructor(private val weatherApiClient: WeatherApiClient) {

    companion object {
        private const val TAG = "----- WeatherService -----"
    }

    suspend fun getWeatherData(): ForecastResponseModel =
        try {
            Log.i(TAG, "Method Called: getWeatherData()")
            val result: Response<ForecastResponseModel?> = weatherApiClient.getWeatherData()
            Log.i(TAG, "$result")
            result.body() ?: ForecastResponseModel()
        } catch (e: Exception) {
            Log.i(TAG, "Exception: $e")
            ForecastResponseModel()
        }
}