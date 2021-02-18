package com.example.myweatherapp.mvp.presenter

import com.example.myweatherapp.mvp.model.MyWeatherAppDetailModel
import com.example.myweatherapp.mvp.utils.Utils.DATE_ONE
import com.example.myweatherapp.mvp.utils.Utils.weatherList
import com.example.myweatherapp.mvp.view.MyWeatherAppDetailView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class MyWeatherAppDetailPresenterTest {
    private val view: MyWeatherAppDetailView = mock()
    private lateinit var  model: MyWeatherAppDetailModel
    private lateinit var presenter: MyWeatherAppDetailPresenter

    @Before
    fun setUp() {
        model = MyWeatherAppDetailModel()
        presenter = MyWeatherAppDetailPresenter(model, view)
    }

    @Test
    fun `when a weather item is pressed, retrieve weather every three hours for that day selected`() {
        presenter.retrieveWeather(DATE_ONE, weatherList)
        verify(view).showFragmentData(model.getDataOnlyOneDay(weatherList, DATE_ONE))
    }
}
