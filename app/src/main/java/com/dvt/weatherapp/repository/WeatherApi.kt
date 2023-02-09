package com.dvt.weatherapp.repository

import com.dvt.weatherapp.models.WeatherApiResponse
import com.dvt.weatherapp.models.WeatherListResponse
import com.dvt.weatherapp.models.WeatherResponse
import com.dvt.weatherapp.network.api.WeatherApiRequests
import com.dvt.weatherapp.network.api.weatherApiCall

import org.koin.java.KoinJavaComponent.inject


class WeatherApi {

    private val weatherApi: WeatherApiRequests by inject(WeatherApiRequests::class.java)

    suspend fun getWeather(
        lat:Double,
        lon:Double
    ): WeatherApiResponse<WeatherResponse> {
        return weatherApiCall(apiCall = {weatherApi.getWeather(lat, lon)})
    }

    suspend fun getWeatherList(
        lat: Double,
        lon:Double
    ):WeatherApiResponse<WeatherListResponse>{
        return weatherApiCall(apiCall = {weatherApi.getWeatherForecast(lat, lon)})
    }
}