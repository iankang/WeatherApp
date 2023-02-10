package com.dvt.weatherapp.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dvt.weatherapp.domain.entities.WeatherResponseEntity

@Dao
interface WeatherAppDAO {
    @Query("SELECT * FROM weather_tbl")
    suspend fun getAllWeather():List<WeatherResponseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather:WeatherResponseEntity)

    @Query("SELECT COUNT(*) FROM weather_tbl")
    suspend fun count():Long

    @Delete
    suspend fun deleteWeather(weather: WeatherResponseEntity)
}