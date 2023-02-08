package com.dvt.weatherapp.models


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    var coord: CoordX?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("population")
    var population: Int?,
    @SerializedName("sunrise")
    var sunrise: Int?,
    @SerializedName("sunset")
    var sunset: Int?,
    @SerializedName("timezone")
    var timezone: Int?
)