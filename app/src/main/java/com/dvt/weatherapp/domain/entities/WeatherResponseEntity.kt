package com.dvt.weatherapp.domain.entities


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dvt.weatherapp.domain.models.*
import com.google.gson.annotations.SerializedName

@Entity

data class WeatherResponseEntity(

    @SerializedName("base")
    var base: String?,
    @SerializedName("clouds")
    @Embedded
    var clouds: Clouds?,
    @SerializedName("cod")
    var cod: Int?,
    @SerializedName("coord")
    @Embedded
    var coord: Coord?,
    @SerializedName("dt")
    var dt: Int?,
    @SerializedName("id")
    @PrimaryKey
    var id: Int?,
    @SerializedName("main")
    @Embedded
    var main: Main?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("sys")
    @Embedded
    var sys: Sys?,
    @SerializedName("timezone")
    var timezone: Int?,
    @SerializedName("visibility")
    var visibility: Int?,
    @SerializedName("weather")
    @Embedded
    var weather: List<Weather?>?,
    @SerializedName("wind")
    @Embedded
    var wind: Wind?,
    var timeAdded:Long?
){
    constructor():this(null,null,null,null,null,null,null,null,null,null,
    null,null,null,System.currentTimeMillis()){

    }
}