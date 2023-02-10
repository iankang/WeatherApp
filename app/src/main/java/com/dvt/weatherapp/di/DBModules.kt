package com.dvt.weatherapp.di

import android.app.Application
import androidx.room.Room
import com.dvt.weatherapp.data.db.WeatherAppDB
import com.dvt.weatherapp.data.db.daos.WeatherAppDAO
import org.koin.dsl.module

val dbModules = module {
    single{ provideDB(get()) }
    single{ provideDao(get()) }
}

fun provideDao(database:WeatherAppDB): WeatherAppDAO {
    return database.weatherAppDAO
}

fun provideDB(application: Application):WeatherAppDB{
    return Room.databaseBuilder(application,WeatherAppDB::class.java,"WEATHERDB")
        .fallbackToDestructiveMigration()
        .build()
}