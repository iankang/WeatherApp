package com.dvt.weatherapp.domain.entities


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dvt.weatherapp.domain.models.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather_tbl")
data class WeatherResponseEntity(
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("clouds")
    @Embedded
    val clouds: Clouds? = null,
    @SerializedName("cod")
    val cod: Int? = null,
    @SerializedName("coord")
    @Embedded
    val coord: Coord? = null,
    @SerializedName("dt")
    val dt: Int? = null,
    @SerializedName("id")
    @PrimaryKey
    val id: Int? = null,
    @SerializedName("main")
    @Embedded
    val main: Main? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("sys")
    @Embedded
    val sys: Sys? = null,
    @SerializedName("timezone")
    val timezone: Int? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    val weather: WeatherListEntity? = null,
    @SerializedName("wind")
    @Embedded
    val wind: Wind? = null,
    val timeAdded:Long? = System.currentTimeMillis()
){
    constructor():this(null,null,null,null,null,null,null,null,null,null,
    null,null,null,System.currentTimeMillis()){

    }
    constructor(base: String?, clouds: Clouds?, cod: Int?, coord: Coord?, dt: Int?, id:Int?, main: Main?, name: String?, sys: Sys?, timezone: Int?, visibility: Int?, weather: WeatherListEntity?, wind: Wind?):
            this(base, clouds, cod, coord, dt, id, main, name, sys, timezone, visibility, weather, wind, System.currentTimeMillis())
}