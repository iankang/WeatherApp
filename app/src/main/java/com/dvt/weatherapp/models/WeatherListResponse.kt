package com.dvt.weatherapp.models


import com.google.gson.annotations.SerializedName

data class WeatherListResponse(
    @SerializedName("city")
    var city: CityX?,
    @SerializedName("cnt")
    var cnt: Int?,
    @SerializedName("cod")
    var cod: String?,
    @SerializedName("list")
    var list: List<WeatherList>?,
    @SerializedName("message")
    var message: Int?
)