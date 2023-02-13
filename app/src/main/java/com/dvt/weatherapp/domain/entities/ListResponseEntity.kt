package com.dvt.weatherapp.domain.entities

import com.dvt.weatherapp.domain.models.WeatherList
import com.google.gson.annotations.SerializedName

class ListResponseEntity(
    @SerializedName("list")
    var list: List<WeatherList>? = null
)