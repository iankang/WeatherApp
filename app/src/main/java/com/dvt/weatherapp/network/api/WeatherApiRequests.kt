package com.dvt.weatherapp.network.api

import com.dvt.weatherapp.BuildConfig
import com.dvt.weatherapp.models.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiRequests {

//    @GET("/api/business/businesses")
//    suspend fun getAllBusinesses():Response<AllBusinessResponse>
//
//    @GET("/api/survey/{businessId}/surveys")
//    suspend fun getAllSurveys(
//        @Path("businessId") businessId:String? = "",
//    ):Response<AllSurveysResponse>
//
//    @GET("/api/question/{surveyId}/questions")
//    suspend fun getSurveyQuestions(
//        @Path("surveyId") surveyId:String? = "",
//    ):Response<SurveyQuestionsAndAnswersResponse>
//
//    @POST ("/api/surveyResponse/addResponse")
//    suspend fun answerSurveyQuestion(
//        @Query("surveyId") surveyId:String?,
//        @Query("questionId") questionId:String?,
//        @Query("answerId") answerId:String?,
//        @Query("email") email:String?,
//    ):Response<SurveyResponse>

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("appid") appid:String = BuildConfig.weather_api_token
    ):Response<WeatherResponse>

    suspend fun getWeatherForecast(

    ):Response<>
}