package com.android.archelon.repository

import androidx.lifecycle.LiveData
import com.android.archelon.dao.ArchelonDao
import com.android.archelon.entities.User

class ArchelonRepository (private val archelonDao: ArchelonDao) {
    suspend fun insertUser(user: User) {
        archelonDao.insertUser(user)
    }

    fun getUser(email: String): LiveData<List<User>> {
        return archelonDao.getUser(email)
    }
}