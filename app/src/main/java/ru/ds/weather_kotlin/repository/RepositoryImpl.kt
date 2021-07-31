package ru.ds.weather_kotlin.repository

import ru.ds.weather_kotlin.Repository
import ru.ds.weather_kotlin.data.Weather
import ru.ds.weather_kotlin.data.getRussianCities
import ru.ds.weather_kotlin.data.getWorldCities


class RepositoryImpl : Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalStorageRus(): List<Weather> {
        return getRussianCities()
    }

    override fun getWeatherFromLocalStorageWorld(): List<Weather> {
        return getWorldCities()
    }
}