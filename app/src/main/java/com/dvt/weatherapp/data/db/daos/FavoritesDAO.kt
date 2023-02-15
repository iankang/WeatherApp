package com.dvt.weatherapp.data.db.daos

import androidx.room.*
import com.dvt.weatherapp.domain.entities.FavoriteSearchEntity

@Dao
interface FavoritesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(favorite: FavoriteSearchEntity)

    @Query("SELECT * FROM favourites WHERE isFavourite = true")
    suspend fun getAllFavourites():List<FavoriteSearchEntity>?

    @Query("SELECT * FROM favourites WHERE placeId = :placeId")
    suspend fun getByPlaceId(placeId:String):FavoriteSearchEntity?

    @Query("SELECT * FROM favourites")
    suspend fun getAllFavoritesEverything():List<FavoriteSearchEntity>?

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteSearchEntity)
}