package com.dvt.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dvt.weatherapp.screens.TemperatureRangeBar
import com.dvt.weatherapp.screens.TopWeatherGraphicPreview
import com.dvt.weatherapp.screens.WeatherList
import com.dvt.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
               MainScaffold()
            }
        }
    }
}

@Composable
fun MainScaffold() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            TopWeatherGraphicPreview()
            TemperatureRangeBar()
            WeatherList()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        MainScaffold()
    }
}