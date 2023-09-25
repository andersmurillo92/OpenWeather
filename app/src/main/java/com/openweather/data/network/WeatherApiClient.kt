package com.openweather.data.network

import com.openweather.data.model.ForecastResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {

    // TODO("Remove hardcoded values")

    @GET("forecast?")
    fun getWeatherData(@Query("lat") latitude: String? = "4.6116516",
                       @Query("lon") longitude: String? = "-74.1059474",
                       @Query("units") units: String? = "imperial",
                       @Query("appid") appid: String = "078a420a8790df5a431a9faf14d61b67"): Response<ForecastResponseModel?>
}