package com.example.weatherapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.navigation.Screen
import com.example.weatherapp.data.Forecastday
import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.util.ForecastScreenState
import dagger.hilt.android.components.ViewWithFragmentComponent

@Composable
fun ForecastScreen(
    viewModel: WeatherForecastViewModel,
    navController: NavController
) {
    val forecastScreenState by viewModel.weatherData.observeAsState(initial = ForecastScreenState.Loading)

    when (val state = forecastScreenState) {
        is ForecastScreenState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ForecastScreenState.Success -> {
            ForecastList(data = state.data, viewModel = viewModel, navController = navController)

        }

        is ForecastScreenState.Error -> {
            Text(text = state.message)
        }
    }
}

@Composable
fun ForecastList(
    data: WeatherData,
    viewModel: WeatherForecastViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${data.location.name} 7 day forecast",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        LazyColumn {
            items(data.forecast.forecastday) { it ->
                Column() {
                    ForecastItem(forecastDay = it, viewModel = viewModel) {
                        viewModel.selectedDay = it
                        navController.navigate(route = Screen.WeatherDetail.route)
                    }
                }
            }
        }
    }
}

@Composable
fun ForecastItem(
    forecastDay: Forecastday,
    viewModel: WeatherForecastViewModel,
    onItemClick: (Forecastday) -> Unit
) {
    Card(shape = RectangleShape, elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp
    ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(forecastDay) }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = "https:${forecastDay.day.condition.icon}",
                contentDescription = stringResource(R.string.weather_image),
                modifier = Modifier
                    .size(64.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(start = 8.dp)) {
                val dayDate = viewModel.getDayandDate(forecastDay.date)
                if (dayDate != null) {
                    Text(text = dayDate)
                }
                Text(text = forecastDay.day.condition.text)
            }
        }
    }
}





