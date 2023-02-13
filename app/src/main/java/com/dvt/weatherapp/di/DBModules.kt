package com.dvt.weatherapp.di

import android.app.Application
import androidx.room.Room
import com.dvt.weatherapp.data.db.WeatherAppDB
import com.dvt.weatherapp.data.db.daos.WeatherAppDAO
import com.dvt.weatherapp.data.db.daos.WeatherForecastDAO
import org.koin.dsl.module

val dbModules = module {
    single{ provideDB(get()) }
    single{ provideDao(get()) }
    single{ provideWeatherForecastDAO(get()) }
}

fun provideDao(database:WeatherAppDB): WeatherAppDAO {
    return database.weatherAppDAO
}

fun provideWeatherForecastDAO(database: WeatherAppDB):WeatherForecastDAO {
    return database.weatherForecastDAO
}

fun provideDB(application: Application):WeatherAppDB{
    return Room.databaseBuilder(application,WeatherAppDB::class.java,"WEATHERDB")
        .fallbackToDestructiveMigration()
        .build()
}