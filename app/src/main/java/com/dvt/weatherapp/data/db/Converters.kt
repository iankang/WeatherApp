package com.dvt.weatherapp.data.db

import androidx.room.TypeConverter
import com.dvt.weatherapp.domain.entities.ListResponseEntity
import com.dvt.weatherapp.domain.entities.WeatherListEntity
import com.dvt.weatherapp.domain.entities.WeatherListResponseEntity
import com.dvt.weatherapp.domain.models.WeatherList
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromWeatherListEntity(sh: WeatherListEntity): String {
        return Gson().toJson(sh)
    }
    @TypeConverter
    fun toWeatherListEntity(sh: String): WeatherListEntity {
        return Gson().fromJson(sh,WeatherListEntity::class.java)
    }
    @TypeConverter
    fun fromWeatherForecastEntity(sh: ListResponseEntity): String {
        return Gson().toJson(sh)
    }
    @TypeConverter
    fun toWeatherForecastEntity(sh: String):  ListResponseEntity{
        return Gson().fromJson(sh,ListResponseEntity::class.java)
    }
}