package com.bignerdranch.android.login.repository

import androidx.lifecycle.LiveData
import com.bignerdranch.android.login.database.ArchelonDbDao
import com.bignerdranch.android.login.database.User

class ArchelonRepository(private val archelonDao: ArchelonDbDao) {

    fun getLogin(email:String) : LiveData<List<User>>?  {
        return archelonDao.getUser(email)
    }
}