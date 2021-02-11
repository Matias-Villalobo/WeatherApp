package com.example.myweatherapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

const val CITY = "Tandil"
const val EMPTY_STRING = ""
const val URL = "http://openweathermap.org/img/wn/"
const val FORMAT = "@2x.png"
val formatJson = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
val formatApp = SimpleDateFormat("EEEE, MM/dd", Locale.ENGLISH)
val daysFormat = SimpleDateFormat("yyyy-MM-dd")
val hoursFormat = SimpleDateFormat("HH:mm")
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val UNITS = "metric"
const val HOUR = "12:00:00"
