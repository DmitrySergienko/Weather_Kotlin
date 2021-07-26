package ru.ds.weather_kotlin

import ru.geekbrains.javatokotlin.data.Weather

open class Repository : IRepository {

    private val weathers: List<Weather>

    init {

        val weather = Weather(temperature = 20, town = "City")

        val weather2 = weather.copy()

        val (a, b) = weather2

        val weather3 = Weather(a, b)

        weathers = listOf(
                Weather("Москва", 25),
                Weather("Санкт-Петербург", 20),
                Weather("Самара", 23),
                Weather("Новосибирск", 15),
                weather,
                weather2,
                weather3
        )
    }

    override fun getWeathers(): List<Weather> {
        return weathers
    }
}

interface IRepository{
    fun getWeathers(): List<Weather>
}

// RepositorySingle.INSTANCE.getWeathers() - for JAVA
object RepositorySingle : IRepository {

    private val weathers: List<Weather> = listOf(
            Weather("Москва", 25),
            Weather("Санкт-Петербург", 20),
            Weather("Самара", 23),
            Weather("Новосибирск", 15),
            Weather(),
            Weather("Магадан")
    )

    override fun getWeathers(): List<Weather> {
        return weathers
    }
}

inline fun getRepository(): IRepository{
    return Repository()
}