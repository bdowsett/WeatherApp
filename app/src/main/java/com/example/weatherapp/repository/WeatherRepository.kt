package com.example.weatherapp.repository

import com.example.weatherapp.data.model.WeatherData
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeather(): Response<WeatherData>
}