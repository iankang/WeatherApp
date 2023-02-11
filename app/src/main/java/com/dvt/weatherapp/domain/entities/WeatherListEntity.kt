package com.dvt.weatherapp.domain.entities

import com.dvt.weatherapp.domain.models.Weather
import com.google.gson.annotations.SerializedName

data class WeatherListEntity(
    @SerializedName("weather")
    val weather: List<Weather>? = null,
)
