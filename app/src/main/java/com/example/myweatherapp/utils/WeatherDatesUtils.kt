package com.example.myweatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object WeatherDatesUtils {
    val formatMilitaryTime = SimpleDateFormat(WeatherStringUtils.JSON_MILITARY_TIME_PATTERN, Locale.ENGLISH)
    val formatYearMonthDays = SimpleDateFormat(WeatherStringUtils.JSON_YEAR_MONTHS_DAYS_PATTERN)
    val formatSimpleDate = SimpleDateFormat(WeatherStringUtils.JSON_SIMPLE_DATE_PATTERN)
    val formatHoursMinutes = SimpleDateFormat(WeatherStringUtils.JSON_HOURS_MINUTES_PATTERN, Locale.ENGLISH)
}
