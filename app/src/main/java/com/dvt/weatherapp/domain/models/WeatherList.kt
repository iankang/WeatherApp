package com.dvt.weatherapp.domain.models

import com.google.gson.annotations.SerializedName

data class WeatherList (
    @SerializedName("clouds")
    var clouds: Clouds?,
    @SerializedName("dt")
    var dt: Int?,
    @SerializedName("dt_txt")
    var dtTxt: String?,
    @SerializedName("main")
    var main: MainForecast?,
    @SerializedName("pop")
    var pop: Double?,
    @SerializedName("sys")
    var sys: SysForecast?,
    @SerializedName("visibility")
    var visibility: Int?,
    @SerializedName("weather")
    var weather: List<Weather>?,
    @SerializedName("wind")
    var wind: Wind?
)