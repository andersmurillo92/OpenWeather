package com.openweather.data.model

import java.io.Serializable

data class ThreeHoursDataModel(
    var dt_txt: String? = null,
    var main: MainModel? = null,
    var weather: List<WeatherModel> = emptyList(),
    var wind: WindModel? = null,
    var clouds: CloudModel? = null,
): Serializable
