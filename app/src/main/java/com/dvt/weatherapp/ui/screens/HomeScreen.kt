package com.dvt.weatherapp.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dvt.weatherapp.R
import com.dvt.weatherapp.ui.theme.SEABLUE
import com.dvt.weatherapp.ui.theme.WeatherAppTheme

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun TopWeatherGraphicPreview(){
    WeatherAppTheme {
        TopWeatherGraphic()
    }
}

@Composable
fun TopWeatherGraphic(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(340.dp)){

        Image(
            painter = painterResource(id = R.drawable.sea_sunnypng),
            contentDescription = "sunny image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        TemperatureBox()
    }
}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun TemperatureBoxPreview(){
    WeatherAppTheme {
        TemperatureBox()
    }
}

@Composable
fun TemperatureBox(
    degrees:String? = "25",
    desc:String? = "SUNNY",
    sizeDegree:TextUnit? = 48.sp,
    sizeDesc:TextUnit? = 36.sp
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TemperatureText(degrees, sizeDegree, desc, sizeDesc)
    }
}

@Composable
private fun TemperatureText(
    degrees: String?,
    sizeDegree: TextUnit?,
    desc: String?,
    sizeDesc: TextUnit?
) {
    Text(
        "$degrees\u00B0",
        fontSize = sizeDegree!!,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    Text(
        desc!!,
        fontSize = sizeDesc!!,
        color = Color.White,
    )
}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun TemperatureRangeBarPreview(){
    WeatherAppTheme {
        TemperatureRangeBar()
    }
}
@Composable
fun TemperatureRangeBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = SEABLUE),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TemperatureText(degrees = "19", sizeDegree = 20.sp, desc = "min", sizeDesc = 18.sp)
        }
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TemperatureText(degrees = "25", sizeDegree = 20.sp, desc = "Current", sizeDesc = 18.sp)
        }
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TemperatureText(degrees = "19", sizeDegree = 20.sp, desc = "max", sizeDesc = 18.sp)
        }

    }
}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun dayItemPreview(){
    WeatherAppTheme {
        dayItem()
    }
}
@Composable
fun dayItem(){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(SEABLUE)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        Text(
            "Monday",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(id = R.drawable.clear),
            contentDescription ="weather icon" )

        Text(
            "25\u00B0",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

    }

}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun WeatherListPreview(){
    WeatherAppTheme {
        WeatherList()
    }
}
@Composable
fun WeatherList(){
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ){
       repeat(12){
           item {
               dayItem()
           }
       }
    }
}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun HomeScreen(padding: PaddingValues? = null) {
    Column {
        TopWeatherGraphicPreview()
        TemperatureRangeBar()
        WeatherList()
    }
}