package com.dvt.weatherapp.repository

import com.dvt.weatherapp.data.db.WeatherAppDB
import com.dvt.weatherapp.domain.entities.FavoriteSearchEntity

class FavoritesRepository(
     private val weatherAppDB: WeatherAppDB
) {

    suspend fun getByPlaceId(placeId:String): FavoriteSearchEntity? {
        return weatherAppDB.favoritesDAO.getByPlaceId(placeId)
    }

    suspend fun getAllFavorites(): List<FavoriteSearchEntity>? {
        return weatherAppDB.favoritesDAO.getAllFavourites()
    }

    suspend fun getEverythingInFavourites(): List<FavoriteSearchEntity>? {
        return weatherAppDB.favoritesDAO.getAllFavoritesEverything()
    }

    suspend fun insertFavourites(favoriteSearchEntity: FavoriteSearchEntity){
        weatherAppDB.favoritesDAO.insertFavourite(favoriteSearchEntity)
    }

    suspend fun deleteFavourite(favoriteSearchEntity: FavoriteSearchEntity){
        return weatherAppDB.favoritesDAO.deleteFavorite(favoriteSearchEntity)
    }
}