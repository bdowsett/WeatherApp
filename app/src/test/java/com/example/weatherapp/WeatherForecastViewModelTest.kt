package com.example.weatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherapp.repository.WeatherRepository
import com.example.weatherapp.screens.WeatherForecastViewModel
import com.example.weatherapp.testutils.CoroutinesTestRule
import com.example.weatherapp.testutils.MockData
import com.example.weatherapp.util.DateProvider
import com.example.weatherapp.util.ForecastScreenState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import retrofit2.Response

class WeatherForecastViewModelTest {

    @get:Rule
    val taskExecutor = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var viewModel: WeatherForecastViewModel

    private val weatherRepository: WeatherRepository = mock()
    private val dateProvider: DateProvider = mock()

    @Before
    fun setup() {
        viewModel = WeatherForecastViewModel(weatherRepository, dateProvider)
    }


    @Test
    fun `getWeather method should update LiveData onSuccess`() = runTest {
        val weatherData = MockData.weatherData

        given(weatherRepository.getWeather()).willReturn(Response.success(weatherData))

        viewModel.getWeather()

        assertEquals(ForecastScreenState.Success(weatherData), viewModel.weatherData.value)

        }


    @Test
    fun `getWeather method should update LiveData onFailure`() = runTest {
        val errorMessage = "Failed to retrieve weather data"

        given(weatherRepository.getWeather()).willReturn(Response.error(404, errorMessage.toResponseBody()))

        viewModel.getWeather()

        assertEquals(ForecastScreenState.Error("Failed to retrieve weather data"), viewModel.weatherData.value)

    }

}