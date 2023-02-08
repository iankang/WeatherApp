package com.dvt.weatherapp.di

import com.dvt.weatherapp.repository.WeatherApi
import org.koin.dsl.module

val weatherRepositoryModule = module {
    single { provideWeatherRepository() }
}

fun provideWeatherRepository(): WeatherApi {
    return WeatherApi()
}