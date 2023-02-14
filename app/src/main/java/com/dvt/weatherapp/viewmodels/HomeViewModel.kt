package com.dvt.weatherapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.dvt.weatherapp.R
import com.dvt.weatherapp.domain.models.LocationDetails
import com.dvt.weatherapp.domain.states.WeatherForecastState
import com.dvt.weatherapp.domain.states.WeatherState
import com.dvt.weatherapp.repository.WeatherForecastRepository
import com.dvt.weatherapp.repository.WeatherRepository
import com.dvt.weatherapp.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class HomeViewModel(
    private val applicationContext: Application,
    private val weatherRepository: WeatherRepository,
    private val weatherForecastRepository: WeatherForecastRepository,
    private val sessionManager: SessionManager
):AndroidViewModel(applicationContext) {

    private var locDetails: LocationDetails? = null
    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.IO)

    private val _weatherState = MutableStateFlow(WeatherState())
    val weatherState: StateFlow<WeatherState> = _weatherState.asStateFlow()

    private val _weatherForecastState = MutableStateFlow(WeatherForecastState())
    val weatherForecastState: StateFlow<WeatherForecastState> = _weatherForecastState.asStateFlow()

    init {
        fetchAndStore()
        fetchAndStoreForecasts()
        getWeather()
        getWeatherForecast()
    }


    fun fetchAndStore() {
        coroutineScope.launch {
            try {
                locDetails = sessionManager.fetchLocation()
                weatherRepository.refreshWeather(locDetails!!)

            } catch (e: Exception) {
                Log.e("exception", e.toString())
            }
        }
    }

    fun fetchAndStoreForecasts(){
        coroutineScope.launch {
            try{
                locDetails = sessionManager.fetchLocation()
                weatherForecastRepository.getAndStoreForecasts(locDetails!!)
            } catch (e:Exception){
                Log.e("ForeCastexception", e.toString())
            }
        }
    }

    fun getWeather(){
        coroutineScope.launch {
            try {
                locDetails = sessionManager.fetchLocation()
                _weatherState.value = WeatherState(isLoading = true)
                val response = weatherRepository.getWeatherFromDB()
                _weatherState.value = WeatherState(
                    isLoading = false,
                    weatherStateResponse = response,
                    hasError = false,
                )
                Log.e("response",response.toString())
            } catch (e:Exception){
                Log.e("exception",e.toString())
            }
        }
    }

    fun getWeatherForecast(){
        coroutineScope.launch {
            try{
                locDetails = sessionManager.fetchLocation()
                _weatherForecastState.value = WeatherForecastState(isLoading = true)
                val response = weatherForecastRepository.getForecastsFromDB()
                _weatherForecastState.value = WeatherForecastState(
                    isLoading = false,
                    weatherForecastStateResponse = response,
                    hasError = false
                )
            } catch (e:Exception){
                Log.e("ForecastException",e.toString())
            }
        }
    }


    fun convertToCelsius(kelvin:Double?):String{
        if(kelvin != null) {
            val celsius = kelvin.minus(273.15)
            return String.format("%.1f", celsius)
        }
        return "0.0"
    }

    fun getBackgroundImage(id:Int): Int {
        return when(true){
            (id < 800) -> R.drawable.sea_rainy
            (id > 800) -> R.drawable.sea_cloudy
            id == null ->R.drawable.sea_sunnypng
            else -> R.drawable.sea_sunnypng
        }
    }

    fun getWeatherIcon(id:Int): Int{
        return when(true){
            (id < 800) -> R.drawable.rain
            (id > 800) -> R.drawable.partlysunny
            else -> R.drawable.clear
        }
    }


    fun getDayOfWeek(epoch:Long): String {
        val sdf = SimpleDateFormat("EEEE")
        val date = Date(epoch)
        return sdf.format(date)
    }

}