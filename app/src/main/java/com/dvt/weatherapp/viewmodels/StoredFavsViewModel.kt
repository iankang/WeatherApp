package com.dvt.weatherapp.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import com.dvt.weatherapp.domain.entities.FavoriteSearchEntity
import com.dvt.weatherapp.repository.FavoritesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StoredFavsViewModel(
    private val applicationContext: Application,
    private val favouritesRepository:FavoritesRepository
):AndroidViewModel(applicationContext) {


    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    private val _favouriteList = MutableStateFlow(mutableListOf<FavoriteSearchEntity>())
    val favouriteListState: StateFlow<MutableList<FavoriteSearchEntity>> = _favouriteList.asStateFlow()

    private val _isfavouriteList = MutableStateFlow(mutableListOf<FavoriteSearchEntity>())
    val isfavouriteListState: StateFlow<MutableList<FavoriteSearchEntity>> = _isfavouriteList.asStateFlow()

    init {
        getAllFavouriteEverything()
    }

    fun getAllFavouriteEverything(){
        coroutineScope.launch {
            _favouriteList.value = favouritesRepository.getEverythingInFavourites()?.toMutableList()!!
        }
    }

    fun getAllIsFavourite(){
        coroutineScope.launch {
            _isfavouriteList.value = favouritesRepository.getAllFavorites()?.toMutableList()!!
        }
    }

    fun toggleFavourite(favouriteEntity: FavoriteSearchEntity){
        coroutineScope.launch {
            favouriteEntity.isFavourite = favouriteEntity.isFavourite != true
            favouritesRepository.insertFavourites(favouriteEntity)
            _favouriteList.value = favouritesRepository.getEverythingInFavourites()?.toMutableList()!!
        }
    }

}