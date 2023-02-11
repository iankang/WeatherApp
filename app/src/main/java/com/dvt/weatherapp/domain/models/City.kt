package com.dvt.weatherapp.domain.models


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    @Embedded
    var coord: Coord?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("id")
    var cityId: Int?,
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