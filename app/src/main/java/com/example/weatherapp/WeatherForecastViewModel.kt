package com.example.weatherapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.Forecastday
import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.util.DateProvider
import com.example.weatherapp.util.ForecastScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherForecastViewModel @Inject constructor(private val weatherRepo: WeatherRepositoryImpl): ViewModel() {

    private val _selectedDay = MutableLiveData<Forecastday>()
    val selectedDay: MutableLiveData<Forecastday>
        get() = _selectedDay

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
                        _weatherData.value = ForecastScreenState.Error("Failed to retrieve weather data")
                    }
                } else {
                    _weatherData.value = ForecastScreenState.Error("Failed to retrieve weather data")
                }
            } catch (e: Exception) {
                _weatherData.value = ForecastScreenState.Error("An error occurred: ${e.message}")
            }
        }
    }

    init{
        getWeather()
    }


    fun setSelectedDay(forecastday: Forecastday){
        selectedDay.value = forecastday
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDayandDate(date: String): Pair<Int, Int>? {
        return DateProvider().calculateDayOfYearAndMonthDay(date)
    }

}