package com.android.archelon.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.archelon.entities.*

@Dao
interface ArchelonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM users_table WHERE email =:email")
    fun getUser(email: String?): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBeach(beach: Beach)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSector(sector: BeachSector)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPrecipitation(precipitation: Precipitation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSky(sky: Sky)


}