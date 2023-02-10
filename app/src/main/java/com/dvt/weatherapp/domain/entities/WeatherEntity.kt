package com.dvt.weatherapp.domain.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class WeatherEntity(
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("icon")
    var icon: String? = null,
    @SerializedName("id")
    @PrimaryKey
    var id: Int? = null,
    @SerializedName("main")
    var main: String? = null
){
}