package ru.ds.weather_kotlin

import ru.ds.weather_kotlin.data.Weather


interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}