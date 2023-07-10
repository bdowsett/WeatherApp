package com.example.weatherapp

import com.example.weatherapp.util.DateProvider
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DayAndDateProviderTest {

    private val dateProvider = DateProvider()


    @Test
    fun testParseStringToDate() {
        val dateString = "2023-07-11"
        val expectedDayAndDate = "Tuesday, July 11"

        val result = dateProvider.parseStringToDayAndDate(dateString)

        assertEquals(expectedDayAndDate, result)
    }

    @Test
    fun testParseStringToDate_InvalidFormat() {
        val dateString = "11/07/2023"
        val result = dateProvider.parseStringToDayAndDate(dateString)

        assertNull(result)
    }

    @Test
    fun testParseStringToDate_InvalidDate() {
        val dateString = "2023-15-40"

        val result = dateProvider.parseStringToDayAndDate(dateString)

        assertNull(result)
    }
}