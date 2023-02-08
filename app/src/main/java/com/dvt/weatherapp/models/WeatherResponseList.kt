package com.dvt.weatherapp.models


import com.google.gson.annotations.SerializedName

data class WeatherResponseList(
    @SerializedName("city")
    var city: City?,
    @SerializedName("cnt")
    var cnt: Int?,
    @SerializedName("cod")
    var cod: String?,
    @SerializedName("list")
    var list: List<>?,
    @SerializedName("message")
    var message: Int?
)