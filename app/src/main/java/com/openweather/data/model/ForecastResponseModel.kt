package com.openweather.data.model

import java.io.Serializable

data class ForecastResponseModel(
    var coord: CoordModel? = null,
    var weather: List<WeatherModel>? = null,
    var main: MainModel? = null,
    var wind: WindModel? = null,
    var clouds: CloudModel? = null,
    var sys: SysModel? = null,
    var name: String? = null,
):Serializable
