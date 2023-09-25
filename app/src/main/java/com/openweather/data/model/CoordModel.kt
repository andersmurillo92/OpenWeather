package com.openweather.data.model

import java.io.Serializable

data class CoordModel(
    var longitude: String? = null,
    var latitude: String? = null
): Serializable
