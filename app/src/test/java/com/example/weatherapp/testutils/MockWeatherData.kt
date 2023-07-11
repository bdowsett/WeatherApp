package com.example.weatherapp.testutils


import com.example.weatherapp.data.model.Astro
import com.example.weatherapp.data.model.Condition
import com.example.weatherapp.data.model.Day
import com.example.weatherapp.data.model.Forecast
import com.example.weatherapp.data.model.Forecastday
import com.example.weatherapp.data.model.Hour
import com.example.weatherapp.data.model.Location
import com.example.weatherapp.data.model.WeatherData


object MockData {

    val weatherData = WeatherData(forecast = Forecast(forecastday = listOf(
        Forecastday(
        astro = Astro(
            is_moon_up = 9107,
            is_sun_up = 5128,
            moon_illumination = "pulvinar",
            moon_phase = "verear",
            moonrise = "eget",
            moonset = "ea",
            sunrise = "graeco",
            sunset = "eu"
        ), date = "laoreet",
            date_epoch = 4610,
            day = Day(
                avghumidity = 60.61,
                avgtemp_c = 62.63,
                avgtemp_f = 64.65,
                avgvis_km = 66.67,
                avgvis_miles = 68.69,
                condition = Condition(
                    code = 6096,
                    icon = "platea",
                    text = "ornatus"
                ),
                daily_chance_of_rain = 7395,
                daily_chance_of_snow = 5088,
                daily_will_it_rain = 5936,
                daily_will_it_snow = 3159,
                maxtemp_c = 70.71,
                maxtemp_f = 72.73,
                maxwind_kph = 74.75,
                maxwind_mph = 76.77,
                mintemp_c = 78.79,
                mintemp_f = 80.81,
                totalprecip_in = 82.83,
                totalprecip_mm = 84.85,
                totalsnow_cm = 86.87,
                uv = 88.89
            ), hour = listOf(
                Hour(chance_of_rain = 4983, chance_of_snow = 4550, cloud = 4818,
                condition = Condition(
                    code = 2357,
                    icon = "eos",
                    text = "ne"
                ),
                dewpoint_c = 90.91,
                dewpoint_f = 92.93,
                feelslike_c = 94.95,
                feelslike_f = 96.97,
                gust_kph = 98.99,
                gust_mph = 100.101,
                heatindex_c = 102.103,
                heatindex_f = 104.105,
                humidity = 7078,
                is_day = 1556,
                precip_in = 106.107,
                precip_mm = 108.109,
                pressure_in = 110.111,
                pressure_mb = 112.113,
                temp_c = 114.115,
                temp_f = 116.117,
                time = "senserit",
                time_epoch = 7879,
                uv = 118.119,
                vis_km = 120.121,
                vis_miles = 122.123,
                will_it_rain = 9505,
                will_it_snow = 8799,
                wind_degree = 9234,
                wind_dir = "ancillae",
                wind_kph = 124.125,
                wind_mph = 126.127,
                windchill_c = 128.129,
                windchill_f = 130.131
            )
            )
    )
    )),
        location = Location(name = "Guadalupe Livingston")
    )
}