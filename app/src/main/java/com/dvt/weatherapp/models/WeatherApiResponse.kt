package com.dvt.weatherapp.models

data class WeatherApiResponse<T>(
    val data: T? = null,
    val message: String? = "Error",
    val isOk:Boolean? = false,
    val isLoading: Boolean? = true,
    val httpStatus:Int? = 500
)