package com.dvt.weatherapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dvt.weatherapp.domain.entities.FavoriteSearchEntity
import com.dvt.weatherapp.domain.models.LocationDetails
import com.dvt.weatherapp.domain.models.PlaceDetails
import com.dvt.weatherapp.domain.states.WeatherForecastState
import com.dvt.weatherapp.repository.FavoritesRepository
import com.dvt.weatherapp.ui.screens.FavoritesScreen
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.inject

class FavouritesViewModel(
    private val applicationContext: Application,
    private val placesClient: PlacesClient,
    private val favouritesRepository: FavoritesRepository
) : AndroidViewModel(applicationContext) {

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    val locationAutofill = mutableStateListOf<FavoriteSearchEntity>()

    private val _searchList = MutableStateFlow(mutableListOf<FavoriteSearchEntity>())
    val searchListState: StateFlow<MutableList<FavoriteSearchEntity>> = _searchList.asStateFlow()
//    val placesClient = Places.createClient(applicationContext)

    private var searchJob: Job? = null
    fun insertFavorite(favoriteSearchEntity: FavoriteSearchEntity){
        coroutineScope.launch {
            favouritesRepository.insertFavourites(favoriteSearchEntity)
        }
    }

    fun getAllFavouriteEverything(){
        coroutineScope.launch {
            favouritesRepository.getEverythingInFavourites()
        }
    }

    fun getByPlaceId(placeId:String): FavoriteSearchEntity? {
        var fav:FavoriteSearchEntity? = null
         coroutineScope.launch {
             fav =  favouritesRepository.getByPlaceId(placeId)
        }
        return fav
    }

    fun updateLatLongByPlaceId(locationDetails: LocationDetails,placeId:String){
        coroutineScope.launch {
            var fav = favouritesRepository.getByPlaceId(placeId)
            if(fav != null){
                fav.latitude = locationDetails.latitude
                fav.longitude = locationDetails.longitude
                favouritesRepository.insertFavourites(fav)
            }
        }
    }

    fun searchPlaces(query: String) {
        searchJob?.cancel()
        locationAutofill.clear()
        searchJob = viewModelScope.launch {
            val request = FindAutocompletePredictionsRequest
                .builder()
                .setQuery(query)
                .build()

            placesClient
                .findAutocompletePredictions(request)
                .addOnSuccessListener { response ->
                    _searchList.value = response.autocompletePredictions.map {
                        Log.e("searchPlaces", it.toString())
                        FavoriteSearchEntity(
                            address = it.getFullText(null).toString(),
                            placeId = it.placeId
                        )

                    }.toMutableList()
                }
                .addOnFailureListener {
                    Log.e("searchPlacesErr", it.toString())
                    it.printStackTrace()
                    println(it.cause)
                    println(it.message)
                }
        }
    }

    fun getCoordinates(result: FavoriteSearchEntity): PlaceDetails {
        var placeDetails = PlaceDetails()
        var locationDetails = LocationDetails(0.0,0.0)
            val placeFields = listOf(Place.Field.LAT_LNG, Place.Field.NAME)
            val request = FetchPlaceRequest.newInstance(result.placeId!!, placeFields)
            placesClient.fetchPlace(request).addOnSuccessListener {
                if (it != null) {
//                currentLatLong = it.place.latLng.
//                    FavoriteSearchEntity(
//                        latitude = it.place.latLng?.latitude,
//                        longitude = it.place.latLng?.longitude
//                    )
                    locationDetails = LocationDetails(it.place.latLng?.latitude!!,it.place.latLng?.longitude!!)
                    placeDetails = PlaceDetails(locationDetails, it.place.name)
                }
            }.addOnFailureListener {
                it.printStackTrace()
            }
        return placeDetails
        }
    }
