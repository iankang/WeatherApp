package com.dvt.weatherapp.di

import com.dvt.weatherapp.viewmodels.FavouritesViewModel
import com.dvt.weatherapp.viewmodels.HomeViewModel
import com.dvt.weatherapp.viewmodels.StoredFavsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModules = module {

    viewModel {
        HomeViewModel(get(),get(),get(),get())
    }

    viewModel {
        FavouritesViewModel(get(),get(),get())
    }

    viewModel {
        StoredFavsViewModel(get(),get())
    }
}


