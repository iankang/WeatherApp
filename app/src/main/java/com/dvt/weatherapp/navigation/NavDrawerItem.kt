package com.dvt.weatherapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dvt.weatherapp.ui.screens.MainScreen
import com.dvt.weatherapp.ui.screens.PlaceDetailScreen
import com.dvt.weatherapp.ui.screens.StoredFavs
import com.dvt.weatherapp.viewmodels.FavouritesViewModel
import com.dvt.weatherapp.viewmodels.StoredFavsViewModel
import kotlinx.coroutines.CoroutineScope


sealed class NavDrawerItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavDrawerItem("home", Icons.Rounded.Home, "Home")
    object Favorites : NavDrawerItem("favorites", Icons.Rounded.Favorite, "Favorites")
    object Places : NavDrawerItem("places", Icons.Rounded.Place, "Place")
}

sealed class BottomNavItem(var title:String, var icon:ImageVector, var screen_route:String){

    object Search : BottomNavItem("Search", Icons.Rounded.Search,"search")
    object Favourites : BottomNavItem("Favourites", Icons.Rounded.Favorite,"favourite")

}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    favouritesViewModel: FavouritesViewModel,
    paddingValues: PaddingValues,
    storedFavsViewModel: StoredFavsViewModel?,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
) {
    NavHost(navController, startDestination = BottomNavItem.Search.screen_route) {
        composable(BottomNavItem.Search.screen_route) {
            MainScreen(navController,favouritesViewModel, scaffoldState, coroutineScope,paddingValues)
        }
        composable(BottomNavItem.Favourites.screen_route) {
            StoredFavs(storedFavsViewModel,paddingValues)
        }
        composable(BottomNavItem.Favourites.screen_route + "/{placeId}") { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId")
            requireNotNull(placeId) { "placeId parameter wasn't found. Please make sure it's set!" }

            PlaceDetailScreen(placeId)
        }

    }
}
