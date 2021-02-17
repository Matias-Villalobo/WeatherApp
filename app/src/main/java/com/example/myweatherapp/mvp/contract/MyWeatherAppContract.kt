package com.example.myweatherapp.mvp.contract

import com.example.myweatherapp.adapter.ItemClicked
import com.example.myweatherapp.data.entity.DaysWeather
import io.reactivex.rxjava3.core.Observable

interface MyWeatherAppContract {

    interface MyWeatherAppModel {
        var weekWeatherList: List<DaysWeather>
        open fun getData(city: String): Observable<List<DaysWeather>>
        open fun getDataAllDays(forecasts: List<DaysWeather>): List<DaysWeather>
    }

    interface MyWeatherAppView {
        fun showData(data: List<DaysWeather>, itemClicked: ItemClicked)
        fun showError()
        fun showFragmentDataDetails(date: String, weatherList: List<DaysWeather>)
        fun showLoading()
        fun hideLoading()

    }

    interface MyWeatherAppPresenter {
        fun getWeatherForecast(itemClicked: ItemClicked)
        fun weatherDayClicked(date: String)
    }
}
