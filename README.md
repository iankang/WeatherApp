
# Weather App

An android app that displays weather data based on location.
changing ui on account of different weather and functional when offline.


## Installation

To get started add your `MAPS_API_KEY=A....` key to the `local.properties` file


## Design Philosophy
The app makes use of dependeny injection via the use of [koin](https://insert-koin.io/docs/setup/koin) dependeny injection tool. MVVM is the architecture of choice.

Caching is implemented using both the [shared preference](https://developer.android.com/reference/android/content/SharedPreferences) and the [Room DB](https://developer.android.com/jetpack/androidx/releases/room)

Network requests are made using the [okHTTP](https://square.github.io/okhttp/) library.

The UI is handled by the [Jetpack Compose](https://developer.android.com/jetpack/compose/documentation)
## Walk through

The Android Mobile application starts by requesting for user permissions relating to location.

This in turn triggers the call to the [weather API](https://openweathermap.org/api) that fetches the current temperature standings as well as the five day forecast.

