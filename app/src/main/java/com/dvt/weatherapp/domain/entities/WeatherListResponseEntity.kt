package com.dvt.weatherapp.domain.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dvt.weatherapp.domain.models.City
import com.dvt.weatherapp.domain.models.WeatherList
import com.google.gson.annotations.SerializedName
@Entity("weather_forecast")
data class WeatherListResponseEntity(
    @SerializedName("city")
    @Embedded
    var city: City?,
    @SerializedName("cnt")
    var cnt: Int?,
    @SerializedName("cod")
    var cod: String?,
    var list: ListResponseEntity,
    @SerializedName("message")
    var message: Int?
){
    @PrimaryKey(autoGenerate = true)
    var id:Long? = null
}