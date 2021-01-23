package com.android.archelon.utils

import com.android.archelon.dao.ArchelonDao
import com.android.archelon.entities.*

class PopulatesDb(private var dao: ArchelonDao) {
    private var beaches :List<String> = listOf("Mavrovouni","Selinitsa","Vathi","Valtaki")
    private var sectors :List<String> = listOf("North","South","East","West")
    private var precipitation: List<String> = listOf("Rain","Hail","Snow")
    private var sky:List<String> = listOf("Clear","Sunny","Cloudy")
    private var wind:List<String> = listOf("Breezy", "Windy")
    private var user = User(0L, "marino.g83@gmail.com", "Bottoncino1")

    fun insertBeach() {
        for(i in 0..(beaches.size)-1) {
            var beach : Beach = Beach(beaches.get(i))
            dao.insertBeach(beach)
        }
    }

    fun insertBeach_Sector() {
        for(i in 0..(sectors.size)-1) {
            var sector : BeachSector = BeachSector(sectors.get(i))
            dao.insertSector(sector)
        }
    }

    fun insertPrecipitation() {
        for(i in 0..(precipitation.size)-1) {
            var precipitation : Precipitation = Precipitation(precipitation.get(i))
            dao.insertPrecipitation(precipitation)
        }
    }

    fun insertSky() {
        for(i in 0..(sky.size)-1) {
            var sky : Sky = Sky(sky.get(i))
            dao.insertSky(sky)
        }
    }

    fun insertWind() {
        for (i in 0..(wind.size) - 1) {
            var wind: Wind = Wind(wind.get(i))
            dao.insertWind(wind)
        }
    }

    fun insertUser() {
        dao.insertUser(user)
    }

}