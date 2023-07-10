package com.example.weatherapp.util

import com.example.weatherapp.data.WeatherData

sealed class ForecastScreenState
{
    object Loading : ForecastScreenState()
    data class Success(val data: WeatherData) : ForecastScreenState()
    data class Error(val message: String) : ForecastScreenState()
}