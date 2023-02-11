package com.dvt.weatherapp.data.db.daos

import androidx.room.*
import com.dvt.weatherapp.domain.entities.WeatherListResponseEntity
import com.dvt.weatherapp.domain.entities.WeatherResponseEntity

@Dao
interface WeatherForecastDAO {
    @Query("SELECT * FROM weather_forecast")
    fun getAllWeatherForecast(): List<WeatherListResponseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherForecast(weather: WeatherListResponseEntity)


    @Query("SELECT COUNT(*) FROM weather_forecast")
    fun count():Long

    @Query("DELETE FROM weather_forecast")
    fun deleteAllWeather()
}