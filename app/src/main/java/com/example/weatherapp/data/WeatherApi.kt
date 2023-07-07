package com.example.weatherapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast.json")
    suspend fun getWeather(@Query("key") apiKey: String,
                           @Query("q") location: String,
                           @Query("days")forecastDays: Int): Response<WeatherData>
}