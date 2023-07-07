package com.example.weatherapp

import com.example.weatherapp.data.Forecastday

sealed class ForecastScreenEvent {
    data class OnDayClicked(val forecastDay: Forecastday): ForecastScreenEvent()
}
