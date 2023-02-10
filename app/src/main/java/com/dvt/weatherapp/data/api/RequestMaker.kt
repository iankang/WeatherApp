package com.dvt.weatherapp.data.api

import android.util.Log
import com.dvt.weatherapp.models.WeatherApiResponse
import kotlinx.coroutines.*
import retrofit2.Response
import java.io.IOException


private val TAG: String = "RequestMaker"
suspend fun <T> weatherApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): WeatherApiResponse<T> {
    return withContext(dispatcher) {
        try {
            val responseDeffered: Deferred<Response<T>> = async { apiCall.invoke() }
            val response = responseDeffered.await()
            Log.d(TAG, "response: ${response.raw()}")
            if (response.isSuccessful) {
                Log.d(TAG, "success")
                WeatherApiResponse(
                    data = response.body(),
                    message = "successful",
                    isOk = true,
                    isLoading = false,
                    httpStatus = response.code()
                )
            } else {
                Log.e(TAG, "error: $response")
                WeatherApiResponse(
                    data = response.body(),
                    message = response.errorBody().toString(),
                    isOk = false,
                    isLoading = false,
                    httpStatus = response.code()
                )
            }

        } catch (error: IOException) {

            WeatherApiResponse(message = error.localizedMessage, isLoading = false)
        }
    }
}
