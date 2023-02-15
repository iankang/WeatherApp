package com.dvt.weatherapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dvt.weatherapp.ui.common.lottieAnimation
import com.dvt.weatherapp.ui.theme.WeatherAppTheme
import com.dvt.weatherapp.viewmodels.StoredFavsViewModel
import com.dvt.weatherapp.R

@Composable
fun StoredFavs(storedFavsViewModel: StoredFavsViewModel?) {
    storedFavsViewModel?.getAllFavouriteEverything()
    val favs = storedFavsViewModel?.favouriteListState?.collectAsState()

    if(favs?.value?.size!! <= 0){
        lottieAnimation(resource = R.raw.nothing_found, size = 400.dp)
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = favs?.value ?: emptyList()) {
                storedFav(it.address,it.isFavourite,{
                    storedFavsViewModel.toggleFavourite(it)
                    storedFavsViewModel.getAllFavouriteEverything()
                })
            }
        }
    }
}
@Composable
@Preview
fun StoredFavsPrev(){
    WeatherAppTheme {
        StoredFavs(null)
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

@Composable
fun storedFav(address: String? = "Rwanda", favourite: Boolean?,onItemClick: () -> Unit){
    Surface(
         modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        border = BorderStroke(4.dp,MaterialTheme.colors.background),
        elevation = 4.dp,
        color = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                address !!
            )
            if(favourite == true) {
                Icon(
                    modifier = Modifier.clickable(enabled = true, onClick = onItemClick),
                    imageVector = Icons.Filled.Star,
                    contentDescription = "favourite"
                )
            } else{
                Icon(
                    modifier = Modifier.size(24.dp).clickable(enabled = true, onClick = onItemClick),
                   painter = painterResource(id = R.drawable.star_outlined),
                    contentDescription = "favourite"
                )
            }
        }
    }
}
@Composable
@Preview
fun storedFavPreview(){
    WeatherAppTheme {
        storedFav(null,null,{})
    }
}