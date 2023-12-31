package com.example.weatherapp.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.Forecastday
import com.example.weatherapp.repository.WeatherRepository
import com.example.weatherapp.util.DateProvider
import com.example.weatherapp.util.ForecastScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherForecastViewModel @Inject constructor(private val weatherRepo: WeatherRepository, private val dateProvider: DateProvider) :
    ViewModel() {

    lateinit var selectedDay: Forecastday

    private val _weatherData = MutableLiveData<ForecastScreenState>()
    val weatherData: MutableLiveData<ForecastScreenState>
        get() = _weatherData

    fun getWeather() {
        viewModelScope.launch {
            try {
                val response = weatherRepo.getWeather()

                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        _weatherData.value = ForecastScreenState.Success(data)
                    } else {
                        _weatherData.value =
                            ForecastScreenState.Error("Failed to retrieve weather data")
                    }
                } else {
                    _weatherData.value =
                        ForecastScreenState.Error("Failed to retrieve weather data")
                }
            } catch (e: Exception) {
                _weatherData.value = ForecastScreenState.Error("An error occurred: ${e.message}")
            }
        }
    }

    init {
        getWeather()
    }

    fun getDayandDate(date: String): String? {
        return dateProvider.parseStringToDayAndDate(date)
    }
}