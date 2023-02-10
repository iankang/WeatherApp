package com.dvt.weatherapp.data.api

import com.dvt.weatherapp.domain.models.WeatherApiResponse
import com.dvt.weatherapp.domain.models.WeatherListResponse
import com.dvt.weatherapp.domain.models.WeatherResponse

import org.koin.java.KoinJavaComponent.inject


class WeatherApi {

    private val weatherApi: WeatherApiRequests by inject(WeatherApiRequests::class.java)

    suspend fun getWeather(
        lat:Double,
        lon:Double
    ): WeatherApiResponse<WeatherResponse> {
        return weatherApiCall(apiCall = {weatherApi.getWeather(lat, lon)})
    }

    suspend fun getWeatherForecast(
        lat: Double,
        lon:Double
    ): WeatherApiResponse<WeatherListResponse> {
        return weatherApiCall(apiCall = {weatherApi.getWeatherForecast(lat, lon)})
    }
}