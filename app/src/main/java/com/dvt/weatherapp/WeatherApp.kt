package com.dvt.weatherapp

import android.app.Application
import com.dvt.weatherapp.di.helperModules
import com.dvt.weatherapp.di.weatherNetworkModule
import com.dvt.weatherapp.di.weatherRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WeatherApp:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
            modules(
                listOf(
                    weatherNetworkModule,
                    weatherRepositoryModule,
                    helperModules
                )
            )
        }
    }
}