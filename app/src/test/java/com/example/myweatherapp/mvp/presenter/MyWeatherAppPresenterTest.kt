package com.example.myweatherapp.mvp.presenter

import com.example.myweatherapp.adapter.ItemClicked
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.service.WeatherService
import com.example.myweatherapp.mvp.model.MyWeatherAppDetailModel
import com.example.myweatherapp.mvp.model.MyWeatherAppModel
import com.example.myweatherapp.mvp.utils.Utils
import com.example.myweatherapp.mvp.utils.Utils.CITY
import com.example.myweatherapp.mvp.utils.Utils.DATE_ONE
import com.example.myweatherapp.mvp.utils.Utils.NUMBER_ZERO
import com.example.myweatherapp.mvp.utils.Utils.weatherList
import com.example.myweatherapp.mvp.view.MyWeatherAppView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.observers.TestObserver
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.Assert
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class MyWeatherAppPresenterTest {

    private var service: WeatherService = mock()
    private var model = MyWeatherAppModel(service)
    private val view: MyWeatherAppView = mock()
    private lateinit var modelDetail: MyWeatherAppDetailModel
    private lateinit var presenter: MyWeatherAppPresenter
    private val item: ItemClicked = mock()
    private lateinit var testObserver: TestObserver<List<DaysWeather>>

    @Before
    fun setUp() {
        presenter = MyWeatherAppPresenter(model, view)
        model = MyWeatherAppModel(WeatherService())
        modelDetail = MyWeatherAppDetailModel()
        testObserver = TestObserver()
    }

    @Test
    fun `response successful, get week weather`() {
        whenever(service.getWeekWeather(CITY)).thenReturn(Observable.just(weatherList))
        presenter.getWeatherForecast(item)
        verify(view).showLoading()
        verify(view).showData(model.getDataAllDays(weatherList), item)
        verify(view).hideLoading()
    }

    @Test
    fun `response not successful, get an error message`() {
        whenever(service.getWeekWeather(CITY)).thenReturn(Observable.error(Throwable()))
        presenter.getWeatherForecast(item)
        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showError()
    }

    @Test
    fun `get weather forecast from a service`() {
        model.getData(CITY).subscribe(testObserver)
        testObserver.onComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        Assert.assertEquals(Utils.NUMBER_FORTY, testObserver.values()[NUMBER_ZERO].size)
        testObserver.dispose()
    }

    @Test
    fun `get weather forecast for the week`() {
        val list = model.getDataAllDays(weatherList)
        Assert.assertEquals(Utils.NUMBER_ONE, list.size)
    }

    @Test
    fun `get the weather forecast when you press a day`() {
        val result = modelDetail.getDataOnlyOneDay(weatherList, Utils.DATE_THREE)
        Assert.assertEquals(Utils.NUMBER_TWO, result.size)
    }

    @Test
    fun `get the weather forecast when you press a day (empty list)`() {
        modelDetail.getDataOnlyOneDay(Utils.weatherListEmpty, Utils.DATE_THREE)
        Assert.assertEquals(
            NUMBER_ZERO,
            modelDetail.getDataOnlyOneDay(Utils.weatherListEmpty, Utils.DATE_THREE).size
        )
    }

    @Test
    fun `show details when an item is press`() {
        presenter.weatherDayClicked(DATE_ONE)
        verify(view).showFragmentDataDetails(DATE_ONE, model.weekWeatherList)
    }

    companion object {
        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            val immediate = object : Scheduler() {
                override fun scheduleDirect(
                    run: Runnable,
                    delay: Long,
                    unit: TimeUnit
                ): Disposable {
                    return super.scheduleDirect(run, NUMBER_ZERO.toLong(), unit)
                }

                override fun createWorker(): Worker {
                    return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false, false)
                }
            }
            RxJavaPlugins.setInitIoSchedulerHandler { immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
        }
    }

}
