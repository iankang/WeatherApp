package com.dvt.weatherapp.screens

import android.content.res.Configuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlacesScreen(){
    Text("Places")
}

@Composable
@Preview(name = "day", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun PlacesScreenPreview(){
    PlacesScreen()
}

