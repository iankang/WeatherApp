package com.dvt.weatherapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoritesScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text("favorites screen")
    }
}

@Composable
@Preview(name = "day", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FavoritesScreenPreview(){
    FavoritesScreen()
}