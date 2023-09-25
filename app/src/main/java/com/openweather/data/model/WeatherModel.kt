package com.openweather.data.model

import java.io.Serializable

const val baseURLImage = "http://openweathermap.org/img/w/"

data class WeatherModel(
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null
): Serializable
