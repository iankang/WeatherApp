package com.dvt.weatherapp.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dvt.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun StoredFavs(){
    Text("storedFavs")
}
@Composable
@Preview
fun StoredFavsPrev(){
    WeatherAppTheme {
        StoredFavs()
    }
}