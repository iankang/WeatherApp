package com.dvt.weatherapp.repository

import com.dvt.weatherapp.data.api.WeatherApi
import com.dvt.weatherapp.data.db.WeatherAppDB
import com.dvt.weatherapp.domain.entities.WeatherListResponseEntity
import com.dvt.weatherapp.domain.models.LocationDetails
import com.dvt.weatherapp.domain.models.WeatherApiResponse
import com.dvt.weatherapp.domain.models.WeatherListResponse
import com.dvt.weatherapp.domain.models.toEntity

class WeatherForecastRepository(
    private val weatherApi: WeatherApi,
    private val weatherAppDB: WeatherAppDB
) {

    suspend fun getAndStoreForecasts(locationDetails: LocationDetails): WeatherApiResponse<WeatherListResponse> {
       val response = weatherApi.getWeatherForecast(locationDetails.latitude, locationDetails.longitude)
        if(response.isOk == true){
            weatherAppDB.weatherForecastDAO.insertWeatherForecast(response.data?.toEntity()!!)
            return response
        }
        return response
    }

    suspend fun getForecastsFromDB(): WeatherListResponseEntity {
        return weatherAppDB.weatherForecastDAO.getAllWeatherForecast()
    }

    suspend fun deleteForecasts(){
        weatherAppDB.weatherForecastDAO.deleteAllWeather()
    }
}