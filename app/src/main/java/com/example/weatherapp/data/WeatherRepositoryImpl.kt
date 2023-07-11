package com.example.weatherapp.data

import com.example.weatherapp.data.model.WeatherData
import com.example.weatherapp.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository{
    override suspend fun getWeather(): Response<WeatherData> {
        val apiKey = "0f485acabb154aeab8a172221230607"
        val location = "London"
        val days = 7
        return api.getWeather(apiKey = apiKey, forecastDays = days, location = location)
    }
}