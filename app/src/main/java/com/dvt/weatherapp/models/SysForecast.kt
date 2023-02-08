package com.dvt.weatherapp.models


import com.google.gson.annotations.SerializedName

data class SysForecast(
    @SerializedName("pod")
    var pod: String?
)