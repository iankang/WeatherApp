package com.dvt.weatherapp.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dvt.weatherapp.domain.entities.WeatherResponseEntity

@Dao
interface WeatherAppDAO {
    @Query("SELECT * FROM weather_tbl")
     fun getAllWeather():WeatherResponseEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertWeather(weather:WeatherResponseEntity)

    @Query("SELECT COUNT(*) FROM weather_tbl")
     fun count():Long

    @Delete
     fun deleteWeather(weather: WeatherResponseEntity)
}