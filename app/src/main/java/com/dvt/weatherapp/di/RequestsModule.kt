package com.dvt.weatherapp.di

import com.dvt.weatherapp.data.api.WeatherApi
import org.koin.dsl.module

val weatherRepositoryModule = module {
    single { provideWeatherRepository() }
}

fun provideWeatherRepository(): WeatherApi {
    return WeatherApi()
}