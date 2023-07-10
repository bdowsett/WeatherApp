package com.example.weatherapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateProvider {


    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateDayOfYearAndMonthDay(dateString: String): Pair<Int, Int>? {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = try {
            LocalDate.parse(dateString, formatter)
        } catch (e: Exception) {
            return null // Return null if the parsing fails
        }

        val dayOfYear = date.dayOfYear
        val monthDay = date.dayOfMonth

        return Pair(dayOfYear, monthDay)
    }

}