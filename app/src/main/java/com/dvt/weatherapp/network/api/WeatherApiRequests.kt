package com.dvt.weatherapp.network.api

import com.dvt.weatherapp.BuildConfig
import com.dvt.weatherapp.models.WeatherListResponse
import com.dvt.weatherapp.models.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiRequests {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = BuildConfig.weather_api_token
    ): Response<WeatherResponse>

    @GET("/data/2.5/forecast")
    suspend fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = BuildConfig.weather_api_token
    ): Response<WeatherListResponse>
}