package com.example.myweatherapp.mvp.contract

interface MyWeatherAppContract {

    interface MyWeatherAppModel {
        fun getData()
    }

    interface MyWeatherAppView {
        fun showData()
    }

    interface MyWeatherAppPresenter {
        fun getWeatherForecast()
    }
}
