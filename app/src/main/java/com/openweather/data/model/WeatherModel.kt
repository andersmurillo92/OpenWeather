package com.openweather.data.model

import java.io.Serializable

data class WeatherModel(
    var description: String? = null,
    var icon: String? = null
): Serializable
