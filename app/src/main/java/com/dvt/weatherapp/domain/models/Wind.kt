package com.dvt.weatherapp.domain.models


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    var deg: Int?,
    @SerializedName("gust")
    var gust: Double?,
    @SerializedName("speed")
    var speed: Double?
)