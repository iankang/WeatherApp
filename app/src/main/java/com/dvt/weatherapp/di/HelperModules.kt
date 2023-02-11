package com.dvt.weatherapp.di

import android.content.Context
import com.dvt.weatherapp.data.api.WeatherApi
import com.dvt.weatherapp.data.db.WeatherAppDB
import com.dvt.weatherapp.repository.WeatherForecastRepository
import com.dvt.weatherapp.repository.WeatherRepository
import com.dvt.weatherapp.utils.SessionManager
import org.koin.dsl.module

val helperModules = module {
    single { provideSessionManager(get()) }
    single { provideRepository(get(), get()) }
    single { provideWeatherForecastRepository(get(), get()) }
}

fun provideSessionManager(context:Context): SessionManager {
    return SessionManager(context)
}

fun provideRepository(weatherApi: WeatherApi, weatherAppDB: WeatherAppDB): WeatherRepository {
    return WeatherRepository(weatherApi, weatherAppDB)
}

fun provideWeatherForecastRepository(weatherApi: WeatherApi, weatherAppDB: WeatherAppDB):WeatherForecastRepository{
    return WeatherForecastRepository(weatherApi, weatherAppDB)
}