package com.example.myweatherapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.databinding.WeatherFragmentInDetailBinding
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract
import com.example.myweatherapp.mvp.model.MyWeatherAppDetailModel
import com.example.myweatherapp.mvp.presenter.MyWeatherAppDetailPresenter
import com.example.myweatherapp.mvp.view.MyWeatherAppDetailView
import com.example.myweatherapp.utils.WeatherStringUtils
import com.example.myweatherapp.utils.WeatherStringUtils.EMPTY_STRING
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.collections.ArrayList

class WeatherFragmentDetail : DialogFragment() {
    private lateinit var binding: WeatherFragmentInDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WeatherFragmentInDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter: MyWeatherAppDetailContract.Presenter =
            MyWeatherAppDetailPresenter(
                MyWeatherAppDetailModel(),
                MyWeatherAppDetailView(this, binding)
            )
        presenter.retrieveWeather(
            arguments?.getString(DATE) ?: EMPTY_STRING,
            arguments?.getSerializable(LIST_WEATHER) as ArrayList<DaysWeather>
        )
        bindViews()
    }

    private fun bindViews() {
        val formatMilitaryTime = SimpleDateFormat(WeatherStringUtils.JSON_MILITARY_TIME_PATTERN, Locale.ENGLISH)
        val formatSimpleDate = SimpleDateFormat(WeatherStringUtils.JSON_SIMPLE_DATE_PATTERN)
        binding.fragmentDate.text = formatSimpleDate.format(formatMilitaryTime.parse(arguments?.getString(DATE)))
        binding.buttonClose.setOnClickListener { dismiss() }
    }

    companion object {
        private const val DATE = "date"
        private const val LIST_WEATHER = "list_weather"
        fun newInstance(
            date: String,
            weatherComplete: ArrayList<DaysWeather>
        ): WeatherFragmentDetail {
            val args = Bundle()
            args.apply {
                putString(DATE, date)
                putSerializable(LIST_WEATHER, weatherComplete)
            }
            val fragment = WeatherFragmentDetail()
            fragment.arguments = args
            return fragment
        }
    }
}
