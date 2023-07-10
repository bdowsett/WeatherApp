package com.example.weatherapp.presentation

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.WeatherForecastViewModel
import com.example.weatherapp.data.Forecastday
import com.example.weatherapp.data.Hour
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun WeatherDetailScreen(viewModel: WeatherForecastViewModel = hiltViewModel()) {

    val data = viewModel.selectedDay.value

    Column(modifier = Modifier
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, ) {
        if (data != null) {
            Weather(day = data, modifier = Modifier)
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
fun HourScreen(hour: Hour) {
    Card(modifier = Modifier.padding(4.dp), shape = RectangleShape, elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp
    )) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(15.dp)) {
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


@Composable fun Weather(day: Forecastday, modifier: Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(vertical = 12.dp)) {
        Text(day.date)
        Text(day.day.condition.text)
        AsyncImage(
            model = "https:${day.day.condition.icon}",
            contentDescription = stringResource(R.string.condition_icon),
            modifier = Modifier
                .size(80.dp)
                .padding()
        )
        Text("max temp ${day.day.maxtemp_c}")
    }
}
    
