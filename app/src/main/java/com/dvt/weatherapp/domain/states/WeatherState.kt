package com.dvt.weatherapp.domain.states

import com.dvt.weatherapp.domain.entities.WeatherResponseEntity
import com.dvt.weatherapp.domain.models.WeatherApiResponse

class WeatherState(
    var isLoading:Boolean = false,
    var weatherStateResponse: WeatherApiResponse<WeatherResponseEntity> = WeatherApiResponse(),
    var hasError:Boolean = false,
    var error:String? = null
) {
}