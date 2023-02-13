package com.dvt.weatherapp.domain.states

import com.dvt.weatherapp.domain.entities.WeatherListResponseEntity

class WeatherForecastState(
    var isLoading: Boolean = false,
    var weatherForecastStateResponse: WeatherListResponseEntity? = null,
    var hasError: Boolean = false,
    var error: String? = null
)