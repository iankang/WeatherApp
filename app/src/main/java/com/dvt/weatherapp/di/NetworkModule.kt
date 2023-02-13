package com.dvt.weatherapp.di

import android.content.Context
import com.dvt.weatherapp.data.api.WeatherApiRequests
import com.dvt.weatherapp.utils.Constants.WEATHER_BASE_API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherNetworkModule = module {
    factory { provideWeatherOkHttpClientInterceptor() }
    factory { provideWeatherOkHttpClient(get()) }
    factory { provideWeatherRetrofit(get()) }
    single { provideWeatherApi(get()) }
}

fun provideWeatherRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(WEATHER_BASE_API)
        .build()
}

fun provideWeatherOkHttpClientInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

fun provideWeatherOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

fun provideWeatherApi(retrofit: Retrofit): WeatherApiRequests {
    return retrofit.create(WeatherApiRequests::class.java)
}