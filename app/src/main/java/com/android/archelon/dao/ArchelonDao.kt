package com.android.archelon.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.android.archelon.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ArchelonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM users_table WHERE email =:email")
    fun getUser(email: String?): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBeach(beach: Beach)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSector(sector: BeachSector)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPrecipitation(precipitation: Precipitation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSky(sky: Sky)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWind(wind: Wind)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLeaders(leader: Leaders)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertObservers(observer: Observers)


    @Query("SELECT * FROM beaches_table")
    fun getAllBeach(): LiveData<List<Beach>>?

    @Query("SELECT * FROM sector_table")
    fun getAllSector(): LiveData<List<BeachSector>>?

    @Query("SELECT * FROM precipitation_table")
    fun getAllPrecipitation(): LiveData<List<Precipitation>>?

    @Query("SELECT * FROM sky_table")
    fun getAllSky(): LiveData<List<Sky>>?

    @Query("SELECT * FROM wind_table")
    fun getAllWind(): LiveData<List<Wind>>?

    @Query("SELECT * FROM observers_table")
    fun getAllObservers(): LiveData<List<Observers>>?

    @Query("SELECT * FROM leaders_table")
    fun getAllLeaders(): LiveData<List<Leaders>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurvey(survey: MorningSurvey?)

}