package com.dvt.weatherapp.di

import android.content.Context
import com.dvt.weatherapp.utils.SessionManager
import org.koin.dsl.module

val helperModules = module {
    single { provideSessionManager(get()) }
}

fun provideSessionManager(context:Context): SessionManager {
    return SessionManager(context)
}