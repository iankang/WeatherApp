package com.dvt.weatherapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.ui.graphics.vector.ImageVector
import com.dvt.weatherapp.R


sealed class NavDrawerItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavDrawerItem("home", Icons.Rounded.Home, "Home")
    object Favorites : NavDrawerItem("favorites", Icons.Rounded.Favorite, "Favorites")
    object Places : NavDrawerItem("places", Icons.Rounded.Place, "Place")
}
