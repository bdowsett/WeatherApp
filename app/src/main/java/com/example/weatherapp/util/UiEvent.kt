package com.example.weatherapp.util

import android.app.UiAutomation

sealed class UiEvent{
    data class Navigate(val route: String):UiEvent()
}
