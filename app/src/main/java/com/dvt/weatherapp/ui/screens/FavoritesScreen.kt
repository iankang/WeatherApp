package com.dvt.weatherapp.ui.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dvt.weatherapp.R
import com.dvt.weatherapp.domain.entities.FavoriteSearchEntity
import com.dvt.weatherapp.viewmodels.FavouritesViewModel
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun FavoritesScreen(
    padding: PaddingValues? = null,
    favouritesViewModel: FavouritesViewModel? = null,
    navController: NavController? = null) {
//    Column(modifier = Modifier.fillMaxSize()) {
//        Text("favorites screen")
//    }

    MainScreen(navController = navController!!,favouritesViewModel)
}

@Composable
@Preview(name = "day", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FavoritesScreenPreview(){
    FavoritesScreen()
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>, favouritesViewModel: FavouritesViewModel?) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
            Log.e("typed", value.text)
            favouritesViewModel?.searchPlaces(value.text)
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    SearchView(textState, null)
}

@Composable
fun LocationListItem(locationText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(locationText) })
            .background(MaterialTheme.colors.background)
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = locationText, fontSize = 18.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun LocationListItemPreview() {
    LocationListItem(locationText = "United States 🇺🇸", onItemClick = { })
}

@Composable
fun LocationList(
    navController: NavController,
    state: MutableState<TextFieldValue>,
    favouritesViewModel: FavouritesViewModel?
) {
    val countries = favouritesViewModel?.searchListState?.collectAsState()
    var filteredCountries: List<FavoriteSearchEntity>
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
//        val searchedText = state.value.text
        filteredCountries = countries?.value ?: emptyList()
        items(filteredCountries) { filteredCountry ->
            LocationListItem(
                locationText = filteredCountry.address ?: "empty add",
                onItemClick = { selectedCountry ->
                    /* Add code later */
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryListPreview() {
    val navController = rememberNavController()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    LocationList(
        navController = navController,
        state = textState,
        favouritesViewModel = null
    )
}

fun getListOfCountries(): ArrayList<String> {
    val isoCountryCodes = Locale.getISOCountries()
    val countryListWithEmojis = ArrayList<String>()
    for (countryCode in isoCountryCodes) {
        val locale = Locale("", countryCode)
        val countryName = locale.displayCountry
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
        val flag =
            (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
        countryListWithEmojis.add("$countryName $flag")
    }
    return countryListWithEmojis
}

@Composable
fun MainScreen(navController: NavController, favouritesViewModel: FavouritesViewModel?) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column {
        SearchView(textState,favouritesViewModel)
        LocationList(navController = navController, state = textState, favouritesViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController, null)
}