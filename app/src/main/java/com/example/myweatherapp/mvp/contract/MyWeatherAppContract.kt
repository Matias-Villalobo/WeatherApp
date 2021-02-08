package com.example.myweatherapp.mvp.contract

import com.example.myweatherapp.data.entity.DaysWeather
import io.reactivex.rxjava3.core.Observable

interface MyWeatherAppContract {

    interface MyWeatherAppModel {
        fun getData(city: String): Observable<List<DaysWeather>>
    }

    interface MyWeatherAppView {
        fun showData(data: List<DaysWeather>)
        fun showError()
    }

    interface MyWeatherAppPresenter {
        fun getWeatherForecast()
    }
}
