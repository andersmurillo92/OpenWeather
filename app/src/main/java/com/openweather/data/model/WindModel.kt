package com.openweather.data.model

import java.io.Serializable

data class WindModel(
    var speed: String? = null,
    var deg: String? = null
): Serializable
