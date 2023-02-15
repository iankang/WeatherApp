package com.dvt.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

import androidx.room.TypeConverters
import com.dvt.weatherapp.data.db.daos.FavoritesDAO
import com.dvt.weatherapp.data.db.daos.WeatherAppDAO
import com.dvt.weatherapp.data.db.daos.WeatherForecastDAO
import com.dvt.weatherapp.domain.entities.FavoriteSearchEntity
import com.dvt.weatherapp.domain.entities.WeatherListResponseEntity
import com.dvt.weatherapp.domain.entities.WeatherResponseEntity
import com.dvt.weatherapp.domain.models.Weather

@Database(entities = [WeatherResponseEntity::class, WeatherListResponseEntity::class, FavoriteSearchEntity::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class WeatherAppDB : RoomDatabase(){
    abstract val weatherAppDAO:WeatherAppDAO
    abstract val weatherForecastDAO:WeatherForecastDAO
    abstract val favoritesDAO:FavoritesDAO
}