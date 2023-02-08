package com.dvt.weatherapp.models


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("lon")
    var lon: Double?
)