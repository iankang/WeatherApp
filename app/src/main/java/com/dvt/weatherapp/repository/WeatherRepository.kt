package com.dvt.weatherapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.dvt.weatherapp.data.api.WeatherApi
import com.dvt.weatherapp.data.db.WeatherAppDB
import com.dvt.weatherapp.domain.entities.WeatherResponseEntity
import com.dvt.weatherapp.domain.models.LocationDetails
import com.dvt.weatherapp.domain.models.WeatherApiResponse
import com.dvt.weatherapp.domain.models.WeatherResponse
import com.dvt.weatherapp.domain.models.toEntity

class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val weatherAppDB: WeatherAppDB
) {

    suspend fun refreshWeather(location: LocationDetails): WeatherApiResponse<WeatherResponse> {

        val response = weatherApi.getWeather(location.latitude, location.longitude)
        if ( response.isOk == true) {
            Log.e("refreshWether","adding to db")
            weatherAppDB.weatherAppDAO.insertWeather(response.data?.toEntity()!!)
            return response
        }
        return response
    }

    suspend fun getWeather(): WeatherResponseEntity {

        return weatherAppDB.weatherAppDAO.getAllWeather()
    }

    suspend fun getWeatherCount(): Long {
        return weatherAppDB.weatherAppDAO.count()
    }
}