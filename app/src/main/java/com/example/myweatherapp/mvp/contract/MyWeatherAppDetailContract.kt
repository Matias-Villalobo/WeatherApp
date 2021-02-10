package com.example.myweatherapp.mvp.contract

import com.example.myweatherapp.data.entity.DaysWeather

interface MyWeatherAppDetailContract {

    interface Model {
        fun getDataOnlyOneDay(forecasts: List<DaysWeather>, date: String): List<DaysWeather>
    }

    interface View {
        fun showFragmentData(forecast: List<DaysWeather>)
        fun showFragmentError()
    }

    interface Presenter {
        fun retrieveWeather(date: String, weatherList: List<DaysWeather>)
    }
}
