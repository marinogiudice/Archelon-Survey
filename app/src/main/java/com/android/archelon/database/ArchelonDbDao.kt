package com.bignerdranch.android.login.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ArchelonDbDao {

    @Insert
    fun insert(user: User)
    @Update
    fun update(user:User)
    @Query("SELECT * from users_table WHERE email = :email")
    fun getUser(email:String): LiveData<List<User>>?

}