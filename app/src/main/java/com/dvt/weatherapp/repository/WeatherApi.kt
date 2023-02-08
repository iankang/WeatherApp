package com.dvt.weatherapp.repository

import com.dvt.weatherapp.network.api.WeatherApiRequests

import org.koin.java.KoinJavaComponent.inject


class WeatherApi {

    private val weatherApi: WeatherApiRequests by inject(WeatherApiRequests::class.java)

//    suspend fun getAllBusinesses(
//    ):SurveyApiResponse<AllBusinessResponse>{
//        return surveyApiCall(apiCall = {surveyApi.getAllBusinesses()})
//    }
//
//    suspend fun getAllSurveys(
//        businessId:String? = "",
//
//    ):SurveyApiResponse<AllSurveysResponse>{
//        return surveyApiCall(apiCall = {surveyApi.getAllSurveys(businessId)})
//    }
//
//    suspend fun getSurveyQuestions(
//        surveyId:String? = null
//    ):SurveyApiResponse<SurveyQuestionsAndAnswersResponse>{
//        return surveyApiCall(apiCall = {surveyApi.getSurveyQuestions(surveyId)})
//    }
//
//    suspend fun answerSurveyQuestion(
//        surveyId: String,
//        questionId:String,
//        answerId:String,
//        email:String
//    ):SurveyApiResponse<SurveyResponse>{
//        return surveyApiCall(apiCall = {surveyApi.answerSurveyQuestion(surveyId, questionId, answerId, email)})
//    }
}