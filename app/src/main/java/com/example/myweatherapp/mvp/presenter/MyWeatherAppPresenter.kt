package com.example.myweatherapp.mvp.presenter

import com.example.myweatherapp.adapter.ItemClicked
import com.example.myweatherapp.mvp.contract.MyWeatherAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MyWeatherAppPresenter(
    private val model: MyWeatherAppContract.MyWeatherAppModel,
    private val view: MyWeatherAppContract.MyWeatherAppView
) :
    MyWeatherAppContract.MyWeatherAppPresenter {

    override fun getWeatherForecast(item: ItemClicked) {
        view.showLoading()
        model.getData(CITY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { forecasts ->
                    view.showData(model.getDataAllDays(forecasts), item)
                    view.hideLoading()
                },
                {
                    view.showError()
                    view.hideLoading()
                })
    }

    override fun weatherDayClicked(date: String) {
        view.showFragmentDataDetails(date, model.weekWeatherList)
    }

    companion object {
        const val CITY = "Tandil"
    }
}
