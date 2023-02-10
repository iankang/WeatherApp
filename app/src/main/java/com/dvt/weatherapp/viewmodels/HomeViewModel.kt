package com.dvt.weatherapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.dvt.weatherapp.domain.models.LocationDetails
import com.dvt.weatherapp.domain.states.WeatherState
import com.dvt.weatherapp.repository.WeatherRepository
import com.dvt.weatherapp.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val applicationContext: Application,
    private val weatherRepository: WeatherRepository,
    private val sessionManager: SessionManager
):AndroidViewModel(applicationContext) {

    private var locDetails: LocationDetails? = null
    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    private val _weatherState = MutableStateFlow(WeatherState())
    val weatherState: StateFlow<WeatherState> = _weatherState.asStateFlow()

    init {
        locDetails = sessionManager.fetchLocation()
        coroutineScope.launch {
            weatherRepository.refreshWeather(locDetails!!)
        }
    }

    fun getWeather(){
        coroutineScope.launch {
            try {
                locDetails = sessionManager.fetchLocation()
                _weatherState.value = WeatherState(isLoading = true)
                val response = weatherRepository.getWeather()
                Log.e("response",response.toString())
            } catch (e:Exception){
                Log.e("exception",e.toString())
            }
        }

    }

}