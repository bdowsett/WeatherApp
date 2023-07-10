package com.example.weatherapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.data.Forecastday
import com.example.weatherapp.data.Hour

@Composable
fun WeatherDetailScreen(viewModel: WeatherForecastViewModel = hiltViewModel()) {

    val data = viewModel.selectedDay

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Weather(day = data, modifier = Modifier, viewModel = viewModel)
        Row() {
            LazyRow {
                items(data.hour) {
                    HourScreen(it)
                }
            }
        }
    }
}

@Composable
fun HourScreen(hour: Hour) {
    Card(
        modifier = Modifier.padding(4.dp),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(15.dp)
        ) {
            Text(hour.time)
            AsyncImage(
                model = "https:${hour.condition.icon}",
                contentDescription = stringResource(
                    R.string.hour_image,
                ),
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp),
            )
            Text(hour.condition.text, fontSize = 18.sp)
            Text(text = "${hour.temp_c}\u2103")
        }
    }
}


@Composable
fun Weather(day: Forecastday, modifier: Modifier, viewModel: WeatherForecastViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(vertical = 12.dp)
    ) {
        val dayDate = viewModel.getDayandDate(day.date)
        if (dayDate != null) {
            Text(dayDate)
        }
        Text(day.day.condition.text)
        AsyncImage(
            model = "https:${day.day.condition.icon}",
            contentDescription = stringResource(R.string.condition_icon),
            modifier = Modifier
                .size(80.dp)
                .padding()
        )
        Text("max temp ${day.day.maxtemp_c}℃")
    }
}
    
