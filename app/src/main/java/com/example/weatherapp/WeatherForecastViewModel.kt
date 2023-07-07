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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherForecastViewModel @Inject constructor(private val weatherRepo: WeatherRepositoryImpl): ViewModel() {

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: MutableLiveData<WeatherData>
        get() = _weatherData

    private val _navigateToDetails = MutableLiveData<Forecastday>()
    val navigateToDetails: LiveData<Forecastday> = _navigateToDetails


    fun getWeather(){
        viewModelScope.launch {
            val response = weatherRepo.getWeather()

            if(response.body() != null){
                val data = response.body()
                weatherData.value = data
            }
        }
    }

    fun navigateToDetails(forecast: Forecastday){
           _navigateToDetails.value = forecast

    }

}