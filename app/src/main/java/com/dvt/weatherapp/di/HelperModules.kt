package com.dvt.weatherapp.di

import android.app.Application
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.dvt.weatherapp.BuildConfig
import com.dvt.weatherapp.data.api.WeatherApi
import com.dvt.weatherapp.data.db.WeatherAppDB
import com.dvt.weatherapp.repository.FavoritesRepository
import com.dvt.weatherapp.repository.WeatherForecastRepository
import com.dvt.weatherapp.repository.WeatherRepository
import com.dvt.weatherapp.utils.SessionManager
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import org.koin.dsl.module

val helperModules = module {
    single { provideSessionManager(get()) }
    single { provideRepository(get(), get()) }
    single { provideWeatherForecastRepository(get(), get()) }
    single { provideFavouritesRepository(get()) }
    single { providePlacesClient(get()) }
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

fun provideFavouritesRepository(weatherAppDB: WeatherAppDB):FavoritesRepository{
    return FavoritesRepository(weatherAppDB)
}

fun providePlacesClient(application: Application): PlacesClient {
    Places.initialize(application, BuildConfig.MAPS_API_KEY)
    return Places.createClient(application)
}