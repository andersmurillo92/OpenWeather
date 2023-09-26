package com.openweather.data.model

import java.io.Serializable

data class ForecastModel(
    var list: List<ThreeHoursDataModel> = emptyList()
):Serializable
