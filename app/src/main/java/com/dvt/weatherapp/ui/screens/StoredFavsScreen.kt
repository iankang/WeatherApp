package com.dvt.weatherapp.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
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

@Composable
fun storedFavItem(){
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {

    }
}
@Composable
@Preview
fun storedFavItemPrev(){
    WeatherAppTheme {
        storedFavItem()
    }
}