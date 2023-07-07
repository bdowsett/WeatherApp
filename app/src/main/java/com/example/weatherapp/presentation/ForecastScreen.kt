package com.example.weatherapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.weatherapp.WeatherForecastViewModel
import com.example.weatherapp.data.Forecastday


@Composable
fun ForecastScreen(viewModel: WeatherForecastViewModel= hiltViewModel()){
    val forecastData by viewModel.weatherData.observeAsState(initial = null)

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 12.dp)) {
        forecastData?.let {data ->
            LazyColumn {
                items(data.forecast.forecastday) {it ->
                    Column() {
                        ForecastItem(forecastDay = it){
                            viewModel.navigateToDetails(it)
                        }
                    }
                }
            }

        }
    }

}

//onEvent

@Composable
    fun ForecastItem(forecastDay: Forecastday, onEvent:(Forecastday)-> Unit){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), onClick = {
                    viewModel.onEvent
            }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = "https:${forecastDay.day.condition.icon}",
                    contentDescription = forecastDay.day.condition.icon,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(4.dp),
                    contentScale = ContentScale.Crop
                )
                Column(Modifier.padding(start = 8.dp)) {
                    Text(text = forecastDay.date)
                    Text(text = forecastDay.day.condition.text)
                }
            }
        }
    }





