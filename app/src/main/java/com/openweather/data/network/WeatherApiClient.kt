package com.openweather.data.network

import com.openweather.data.model.ForecastModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {

    // TODO("Remove hardcoded values")

    @GET("forecast?")
    suspend fun getWeatherData(@Query("lat") latitude: String,
                       @Query("lon") longitude: String,
                       @Query("units") units: String,
                       @Query("appid") appid: String): Response<ForecastModel?>
}