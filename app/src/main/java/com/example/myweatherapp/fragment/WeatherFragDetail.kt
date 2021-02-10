package com.example.myweatherapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.mapper.EMPTY_STRING
import com.example.myweatherapp.data.mapper.formatApp
import com.example.myweatherapp.data.mapper.formatJson
import com.example.myweatherapp.databinding.WeatherFragInDetailBinding
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract
import com.example.myweatherapp.mvp.model.MyWeatherAppDetailModel
import com.example.myweatherapp.mvp.presenter.MyWeatherAppDetailPresenter
import com.example.myweatherapp.mvp.view.MyWeatherAppDetailView

class WeatherFragDetail : DialogFragment() {
    private lateinit var binding: WeatherFragInDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WeatherFragInDetailBinding.inflate(inflater, container, false)
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
        binding.fragmentDate.text = formatApp.format(formatJson.parse(arguments?.getString(DATE)))
        binding.buttonClose.setOnClickListener { dismiss() }
    }

    companion object {
        private const val DATE = "date"
        private const val LIST_WEATHER = "list_weather"
        fun newInstance(date: String, weatherComplete: ArrayList<DaysWeather>): WeatherFragDetail {
            val args = Bundle()
            args.apply {
                putString(DATE, date)
                putSerializable(LIST_WEATHER, weatherComplete)
            }
            val fragment = WeatherFragDetail()
            fragment.arguments = args
            return fragment
        }
    }
}

