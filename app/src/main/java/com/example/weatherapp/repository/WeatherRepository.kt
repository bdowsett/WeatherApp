package com.example.weatherapp.repository

import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.data.model.WeatherDto
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeather(): Response<WeatherData>
}