package com.example.myweatherapp.data.mapper

import com.example.myweatherapp.data.entity.Data
import com.example.myweatherapp.data.entity.Temperature
import com.example.myweatherapp.data.entity.Weather
import com.example.myweatherapp.data.entity.WeatherDescription
import com.example.myweatherapp.data.service.response.WeatherDataResponse
import com.example.myweatherapp.data.service.response.WeatherFullDescriptionResponse
import com.example.myweatherapp.data.service.response.WeatherResponse
import com.example.myweatherapp.data.service.response.WeatherTemperatureResponse

class WeatherMapper {

    fun transform(response: WeatherResponse): Weather {
        return Weather(transformData(response.list))
    }

    private fun transformData(data: List<WeatherDataResponse>): List<Data> {
        val auxData: ArrayList<Data> = arrayListOf()
        data.forEach {
            auxData.add(
                Data(
                    it.date,
                    transformMain(it.main),
                    transformWeatherDescription(it.weatherFullDescription)
                )
            )
        }
        return auxData
    }

    private fun transformMain(main: WeatherTemperatureResponse): Temperature {
        return Temperature(main.feelsLike, main.temp, main.tempMax, main.tempMin)
    }

    private fun transformWeatherDescription(description: List<WeatherFullDescriptionResponse>): List<WeatherDescription> {
        val auxWeatherDescription: ArrayList<WeatherDescription> = arrayListOf()
        description.forEach {
            auxWeatherDescription.add(WeatherDescription(it.description, it.icon, it.id, it.main))
        }
        return auxWeatherDescription
    }

}
