package com.openweather.data.model

import java.io.Serializable

data class MainModel(
    var temp: String? = null,
    var feels_like: String? = null,
    var temp_min: String? = null,
    var temp_max: String? = null,
    var pressure: String? = null,
    var humidity: String? = null
): Serializable
