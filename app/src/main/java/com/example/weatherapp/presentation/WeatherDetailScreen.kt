package com.example.weatherapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.WeatherForecastViewModel
import com.example.weatherapp.data.Forecastday
import com.example.weatherapp.data.Hour

@Composable
fun WeatherDetailScreen(viewModel: WeatherForecastViewModel){

    val data = viewModel.selectedDay.value

    Column(modifier = Modifier.fillMaxWidth()) {
        if (data != null) {

                Text(data.date, modifier = Modifier.fillMaxWidth())
                Row() {
                    LazyRow {

                        items(data.hour) {
                            HourScreen(it)

                        }
                    }
                }
        }
    }

    }

@Composable
fun HourScreen(hour: Hour){
    Card(modifier = Modifier.padding(4.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
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

        }
    }
}
    
