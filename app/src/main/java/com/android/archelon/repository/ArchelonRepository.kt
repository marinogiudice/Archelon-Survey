package com.android.archelon.repository

import androidx.lifecycle.LiveData
import com.android.archelon.database.ArchelonDbDao
import com.android.archelon.database.User

class ArchelonRepository(private val archelonDao: ArchelonDbDao) {

    fun getUser(email:String) : LiveData<User>?  {
        return archelonDao.getUser(email)
    }
}