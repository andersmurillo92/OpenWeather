package com.openweather.data.network

import com.openweather.data.model.ForecastResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {

    @GET("forecast?")
    fun getWeatherData(@Query("lat") latitude: String,
                       @Query("lon") longitude: String,
                       @Query("units") units: String,
                       @Query("appid") appid: String = "078a420a8790df5a431a9faf14d61b67"): Response<ForecastResponseModel?>
}