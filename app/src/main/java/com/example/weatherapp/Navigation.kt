package com.example.weatherapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.presentation.ForecastScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ""){
        val viewmodel = hiltViewModel<WeatherForecastViewModel>()
        composable("forecast") { ForecastScreen(viewModel = )}
    }
}