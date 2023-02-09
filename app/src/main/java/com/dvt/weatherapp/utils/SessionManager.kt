package com.dvt.weatherapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.dvt.weatherapp.R
import com.dvt.weatherapp.models.LocationDetails
import com.google.gson.Gson

class SessionManager(context: Context) {

    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_LOCATION = "user_location"
    }

    /**
     * function to save the location on the local memory
     */
    fun saveLocation(locationDetails: LocationDetails) {
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(locationDetails)
        editor.putString(USER_LOCATION, json)
        editor.apply()
    }

    /**
     * function uses gson to fetch location details
     */
    fun fetchLocation(): LocationDetails? {
        val gson = Gson()
        val json = prefs.getString(USER_LOCATION, "")
        return gson.fromJson(json, LocationDetails::class.java)
    }


    /**
     * function removes location stored on local
     */
    fun removeLocation() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}