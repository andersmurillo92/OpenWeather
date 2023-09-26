package com.openweather.data.network

import android.util.Log
import com.openweather.data.model.ForecastModel
import retrofit2.Response
import javax.inject.Inject

class WeatherService @Inject constructor(private val weatherApiClient: WeatherApiClient) {

    companion object {
        private const val TAG = "----- WeatherService -----"
    }

    suspend fun getWeatherData(): ForecastModel =
        try {
            Log.i(TAG, "Method Called: getWeatherData()")
            val result: Response<ForecastModel?> = weatherApiClient.getWeatherData("41.149472", "-8.610778", "metric", "078a420a8790df5a431a9faf14d61b67")
            Log.i(TAG, "$result")
            result.body() ?: ForecastModel(emptyList())
        } catch (e: Exception) {
            Log.i(TAG, "Exception: $e")
            ForecastModel(emptyList())
        }
}