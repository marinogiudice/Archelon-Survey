package com.android.archelon.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.archelon.entities.*
import com.android.archelon.repository.ArchelonRepository
import com.android.archelon.screens.morningsurvey.MorningSurveyFragment1
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ArchelonViewModel (private val repository: ArchelonRepository) : ViewModel(){

    val loggedIn = MutableLiveData<Boolean>(false)
    val beaches=repository.getAllBeach()
    val allBeachSector=repository.getAllSector()
    val morningSurvey : MorningSurvey =MorningSurvey(0L,"","","","","","","","","")


    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun getUser(email:String) : List<User> {
        return repository.getUser(email)
    }

    fun getAllBeach() : LiveData<List<Beach>>? {
        return repository.getAllBeach()
    }

    fun getAllSector() : LiveData<List<BeachSector>>? {
        return repository.getAllSector()
    }

    fun getAllSky() : LiveData<List<Sky>>? {
        return repository.getAllSky()
    }

    fun getAllPrecipitation() : LiveData<List<Precipitation>>? {
        return repository.getAllPrecipitation()
    }

    fun getAllWind() : LiveData<List<Wind>>? {
        return repository.getAllWind()
    }

    fun login(email:String, password:String) {
       val user = getUser(email)
        if(user.size<=0) {
            loggedIn.value=false
        } else {
            val pass = user[0].Password
            if (pass == password) {
                loggedIn.value = true
                //setUserSurvey(email)
            }
        }
       // val user1 = user.value
        //loggedIn.value = user?.Password==password
    }

    fun setBeachSurvey(par:Beach) {
        morningSurvey?.Beach=par.Name
    }

    fun submit() {
        repository.insertSurvey(morningSurvey)
    }



}


