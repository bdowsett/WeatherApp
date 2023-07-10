package com.example.weatherapp.util

import java.text.ParseException
import java.text.SimpleDateFormat

class DateProvider {

    fun parseStringToDayAndDate(dateString: String): String? {
        val pattern = "yyyy-MM-dd"
        val formatter = SimpleDateFormat(pattern)
        formatter.isLenient = false
        val date = try {
            formatter.parse(dateString)
        } catch (e: ParseException) {
           return null
        }

        return date?.let {
            val dayFormatter = SimpleDateFormat("EEEE")
            val dateFormatter = SimpleDateFormat("MMMM d")
            val dayOfWeek = dayFormatter.format(it)
            val date = dateFormatter.format(it)
            "$dayOfWeek, $date"
        }
    }

}