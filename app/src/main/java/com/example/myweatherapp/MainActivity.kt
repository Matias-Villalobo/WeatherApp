package com.example.myweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myweatherapp.databinding.ActivityMainBinding
import com.example.myweatherapp.mvp.contract.MyWeatherAppContract
import com.example.myweatherapp.mvp.model.MyWeatherAppModel
import com.example.myweatherapp.mvp.presenter.MyWeatherAppPresenter
import com.example.myweatherapp.mvp.view.MyWeatherAppView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MyWeatherAppContract.MyWeatherAppPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MyWeatherAppPresenter(MyWeatherAppModel(), MyWeatherAppView(this,binding))
        presenter.getWeatherForecast()

    }
}
