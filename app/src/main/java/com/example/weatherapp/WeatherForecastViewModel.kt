package com.example.weatherapp

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.Forecastday
import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherForecastViewModel @Inject constructor(private val weatherRepo: WeatherRepositoryImpl): ViewModel() {

    private val _selectedDay = MutableLiveData<Forecastday>()
    val selectedDay: MutableLiveData<Forecastday>
        get() = _selectedDay

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: MutableLiveData<WeatherData>
        get() = _weatherData

    init{
        getWeather()
    }


    private fun getWeather(){
        viewModelScope.launch {
            val response = weatherRepo.getWeather()

            if(response.body() != null){
                val data = response.body()
                weatherData.value = data
            }
        }
    }

    fun setSelectedDay(forecastday: Forecastday){
        selectedDay.value = forecastday
    }

}