package com.dvt.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

import androidx.room.TypeConverters
import com.dvt.weatherapp.data.db.daos.WeatherAppDAO
import com.dvt.weatherapp.domain.entities.WeatherResponseEntity

@Database(entities = [WeatherResponseEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class WeatherAppDB : RoomDatabase(){
    abstract val weatherAppDAO:WeatherAppDAO
}