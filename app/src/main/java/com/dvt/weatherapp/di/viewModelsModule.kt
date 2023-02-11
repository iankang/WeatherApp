package com.dvt.weatherapp.di

import com.dvt.weatherapp.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModules = module {

    viewModel {
        HomeViewModel(get(),get(),get(),get())
    }
}


