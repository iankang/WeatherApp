package com.dvt.weatherapp.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class FavoriteSearchEntity(
    var isFavourite:Boolean? = false,
    var address:String? = null,
    var placeId:String? = null,
    var latitude:Double? = 0.0,
    var longitude:Double? = 0.0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}