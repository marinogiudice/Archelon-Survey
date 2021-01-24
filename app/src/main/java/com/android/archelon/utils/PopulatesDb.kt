package com.android.archelon.utils

import com.android.archelon.dao.ArchelonDao
import com.android.archelon.entities.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO

class PopulatesDb(private var dao: ArchelonDao) {

    private var beaches :List<String> = listOf("Mavrovouni","Selinitsa","Vathi","Valtaki")
    private var sectors :List<String> = listOf("North","South","East","West")
    private var precipitation: List<String> = listOf("None","Rain","Hail","Snow")
    private var sky:List<String> = listOf("Clear","Sunny","Cloudy")
    private var wind:List<String> = listOf("None","Breezy", "Windy")
    private var user = User("volunteer1@archelon.com", "Volunteer1")
    private var leaders :List<String> = listOf("George Roussos", "Cosmin Stamate")
    private var observers: List<String> = listOf("Marino Giudice", "Salik Tariq")

    fun insertUser() {
        dao.insertUser(user)
    }
    fun insertBeach() {
        for(i in 0..(beaches.size)-1) {
            var beach : Beach = Beach(beaches.get(i))
            dao.insertBeach(beach)
        }
    }

    fun insertBeachSector() {
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

    fun insertLeaders() {
        for (i in 0..(leaders.size) - 1) {
            var leader: Leaders = Leaders(leaders.get(i))
            dao.insertLeaders(leader)
        }
    }

    fun insertObservers() {
        for (i in 0..(observers.size) - 1) {
            var observer: Observers = Observers(observers.get(i))
            dao.insertObservers(observer)
        }
    }
}