package com.example.weatherapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.presentation.ForecastScreen
import com.example.weatherapp.presentation.WeatherDetailScreen

@Composable
fun navSetUp(
    navController: NavHostController
) {
    val viewModel = hiltViewModel<WeatherForecastViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screen.WeatherForecast.route
    ) {

        composable(route = Screen.WeatherForecast.route) {

            ForecastScreen(viewModel, navController)
        }

        composable(route = Screen.WeatherDetail.route) {

            WeatherDetailScreen(viewModel)
        }
    }

}