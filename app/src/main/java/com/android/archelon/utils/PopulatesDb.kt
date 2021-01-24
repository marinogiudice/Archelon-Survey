package com.android.archelon.utils

import com.android.archelon.dao.ArchelonDao
import com.android.archelon.entities.*

/**
 * Class PopulatesDb.
 * It is an Utility Class.
 * Contains methods and data used to populate the Db
 * with Dummy data after creation.
 * To modify the dummy data is possible to modify the lists arguments
 * Takes the Dao as parameter
 */
class PopulatesDb(private var dao: ArchelonDao) {
    //Contains the list of Dummy beaches
    private var beaches :List<String> = listOf("Mavrovouni","Selinitsa","Vathi","Valtaki")
    //Contains the List of Dummy Sectors
    private var sectors :List<String> = listOf("North","South","East","West")
    //Contains the list of dummy precipitation
    private var precipitation: List<String> = listOf("None","Rain","Hail","Snow")
    //contains the list of sky condition
    private var sky:List<String> = listOf("Clear","Sunny","Cloudy")
    //contains the list of wind intensity
    private var wind:List<String> = listOf("None","Breezy", "Windy")
    //contain the dummy user instance information
    private var user = User("volunteer1@archelon.gr", "Volunteer1")
    // contains the list of leaders
    private var leaders :List<String> = listOf("George Roussos", "Cosmin Stamate")
    //contains the list of observers
    private var observers: List<String> = listOf("Marino Giudice", "Salik Tariq")

    //use the dao to insert a user instance in the DB
    fun insertUser() {
        dao.insertUser(user)
    }

    /*  Visit the List's elements, creates a Beach object for each element
        and use the Dao to insert each object in the db */

    fun insertBeach() {
        for(i in 0..(beaches.size)-1) {
            var beach : Beach = Beach(beaches.get(i))
            dao.insertBeach(beach)
        }
    }

    /*  Visit the List's elements, creates a BeachSector object for each element
        and use the Dao to insert each object in the db */
    fun insertBeachSector() {
        for(i in 0..(sectors.size)-1) {
            var sector : BeachSector = BeachSector(sectors.get(i))
            dao.insertSector(sector)
        }
    }

    /*  Visit the List's elements, creates a Precipitation object for each element
        and use the Dao to insert each object in the db */
    fun insertPrecipitation() {
        for(i in 0..(precipitation.size)-1) {
            var precipitation : Precipitation = Precipitation(precipitation.get(i))
            dao.insertPrecipitation(precipitation)
        }
    }

    /*  Visit the List's elements, creates a Sky object for each element
        and use the Dao to insert each object in the db */
    fun insertSky() {
        for(i in 0..(sky.size)-1) {
            var sky : Sky = Sky(sky.get(i))
            dao.insertSky(sky)
        }
    }

    /*  Visit the List's elements, creates a Wind object for each element
        and use the Dao to insert each object in the db */
    fun insertWind() {
        for (i in 0..(wind.size) - 1) {
            var wind: Wind = Wind(wind.get(i))
            dao.insertWind(wind)
        }
    }

    /*  Visit the List's elements, creates a Leaders object for each element
        and use the Dao to insert each object in the db */
    fun insertLeaders() {
        for (i in 0..(leaders.size) - 1) {
            var leader: Leaders = Leaders(leaders.get(i))
            dao.insertLeaders(leader)
        }
    }

    /*  Visit the List's elements, creates a Observers object for each element
        and use the Dao to insert each object in the db */
    fun insertObservers() {
        for (i in 0..(observers.size) - 1) {
            var observer: Observers = Observers(observers.get(i))
            dao.insertObservers(observer)
        }
    }
}