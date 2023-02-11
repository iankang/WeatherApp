package com.dvt.weatherapp.domain.models


import com.dvt.weatherapp.domain.entities.ListResponseEntity
import com.dvt.weatherapp.domain.entities.WeatherListResponseEntity
import com.google.gson.annotations.SerializedName

data class WeatherListResponse(
    @SerializedName("city")
    var city: City?,
    @SerializedName("cnt")
    var cnt: Int?,
    @SerializedName("cod")
    var cod: String?,
    @SerializedName("list")
    var list: List<WeatherList>?,
    @SerializedName("message")
    var message: Int?
)


fun WeatherListResponse.toEntity(): WeatherListResponseEntity {
    return WeatherListResponseEntity(
        city = city,
        cnt = cnt,
        cod = cod,
        list = ListResponseEntity(list),
        message = message
    )
}