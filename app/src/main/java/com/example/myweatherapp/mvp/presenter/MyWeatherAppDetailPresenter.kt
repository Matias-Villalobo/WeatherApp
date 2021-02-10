package com.example.myweatherapp.mvp.presenter

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract

class MyWeatherAppDetailPresenter(
    private val model: MyWeatherAppDetailContract.Model,
    private val view: MyWeatherAppDetailContract.View
) : MyWeatherAppDetailContract.Presenter {

    override fun retrieveWeather(date: String, weatherList: List<DaysWeather>) {
        view.showFragmentData(model.getDataOnlyOneDay(weatherList, date))
    }

}
