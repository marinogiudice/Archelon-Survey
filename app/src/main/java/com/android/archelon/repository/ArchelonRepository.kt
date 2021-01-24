package com.android.archelon.repository

import androidx.lifecycle.LiveData
import com.android.archelon.dao.ArchelonDao
import com.android.archelon.entities.*


class ArchelonRepository (private val archelonDao: ArchelonDao) {

    fun insertUser(user: User) {
        archelonDao.insertUser(user)
    }

    fun getUser(email: String): List<User> {
        return archelonDao.getUser(email)
    }

    fun getAllBeach() : LiveData<List<Beach>>? {
        return archelonDao.getAllBeach()
    }

    fun getAllSector() : LiveData<List<BeachSector>>? {
        return archelonDao.getAllSector()
    }

    fun getAllPrecipitation() : LiveData<List<Precipitation>>? {
        return archelonDao.getAllPrecipitation()
    }

    fun getAllSky() : LiveData<List<Sky>>? {
        return archelonDao.getAllSky()
    }

    fun getAllWind() : LiveData<List<Wind>>? {
        return archelonDao.getAllWind()
    }

    fun getAllObservers() : LiveData<List<Observers>>? {
        return archelonDao.getAllObservers()
    }

    fun getAllLeaders() : LiveData<List<Leaders>>? {
        return archelonDao.getAllLeaders()
    }

    fun insertSurvey(survey: MorningSurvey) {
        archelonDao.insertSurvey(survey)
    }

}