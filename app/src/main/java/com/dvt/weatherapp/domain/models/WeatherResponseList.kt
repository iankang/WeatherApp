package com.dvt.weatherapp.domain.models


import com.google.gson.annotations.SerializedName

data class WeatherResponseList(
    @SerializedName("city")
    var city: City?,
    @SerializedName("cnt")
    var cnt: Int?,
    @SerializedName("cod")
    var cod: String?,
    @SerializedName("list")
    var list: List<WeatherList>?,
    @SerializedName("message")
    var message: Int?
)