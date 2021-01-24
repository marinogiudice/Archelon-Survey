package com.android.archelon.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.archelon.entities.*

/**
 * ArchelonDao "Dao" interface.
 * Offers methods to interact with the room database.
 *
 */

@Dao
interface ArchelonDao {

    //insert a User in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    //returns a list of "User" which email matches tha parameter
    @Query("SELECT * FROM users_table WHERE email =:email")
    fun getUser(email: String?): List<User>

    //insert a Beach object in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBeach(beach: Beach)

    //insert a BeachSector object in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSector(sector: BeachSector)

    //insert a precipitation object in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPrecipitation(precipitation: Precipitation)

    //insert a sky object in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSky(sky: Sky)

    //insert a wind object in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWind(wind: Wind)

    //insert a Leaders object in the db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLeaders(leader: Leaders)

    //insert a Observers object in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertObservers(observer: Observers)

    //insert a morningSurveyObject in the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurvey(survey: MorningSurvey?)

    /*  Query the Db for all the values of the beaches table.
        Returns a List of Beach Objects as LiveData
     */
    @Query("SELECT * FROM beaches_table")
    fun getAllBeach(): LiveData<List<Beach>>?

    /*  Query the Db for all the values of the sector table.
        Returns a List of BeachSector Objects as LiveData
     */
    @Query("SELECT * FROM sector_table")
    fun getAllSector(): LiveData<List<BeachSector>>?

    /*  Query the Db for all the values of the precipitation table.
        Returns a List of Precipitation Objects as LiveData
     */
    @Query("SELECT * FROM precipitation_table")
    fun getAllPrecipitation(): LiveData<List<Precipitation>>?

    /*  Query the Db for all the values of the sky table.
        Returns a List of Sky Objects as LiveData
     */
    @Query("SELECT * FROM sky_table")
    fun getAllSky(): LiveData<List<Sky>>?

    /*  Query the Db for all the values of the wind table.
        Returns a List of Wind Objects as LiveData
     */
    @Query("SELECT * FROM wind_table")
    fun getAllWind(): LiveData<List<Wind>>?

    /*  Query the Db for all the values of the observer table.
       Returns a List of Observers Objects as LiveData
    */
    @Query("SELECT * FROM observers_table")
    fun getAllObservers(): LiveData<List<Observers>>?

    /*  Query the Db for all the values of the leaders table.
       Returns a List of Leaders Objects as LiveData
    */
    @Query("SELECT * FROM leaders_table")
    fun getAllLeaders(): LiveData<List<Leaders>>?


}