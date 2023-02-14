package com.dvt.weatherapp.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dvt.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun PlaceDetailScreen(placeId: String? = null) {
    Text("place detail: $placeId")
}

@Composable
@Preview()
fun PlaceDetailScreenPrev(){
    WeatherAppTheme {
        PlaceDetailScreen()
    }
}