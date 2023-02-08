package com.dvt.weatherapp.models


import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country")
    var country: String?,
    @SerializedName("sunrise")
    var sunrise: Int?,
    @SerializedName("sunset")
    var sunset: Int?
)