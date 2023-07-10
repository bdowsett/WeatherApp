package com.example.weatherapp.navigation

sealed class Screen(val route: String) {
    object WeatherForecast: Screen(route = "weather_forecast")
    object WeatherDetail: Screen(route = "detail_screen")
}