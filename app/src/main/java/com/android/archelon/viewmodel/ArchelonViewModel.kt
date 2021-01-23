package com.android.archelon.viewmodel

import android.icu.text.SimpleDateFormat
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
import java.sql.Timestamp
import java.util.*

class ArchelonViewModel (private val repository: ArchelonRepository) : ViewModel() {

    val loggedIn = MutableLiveData<Boolean>(false)
    val beaches=repository.getAllBeach()
    val allBeachSector=repository.getAllSector()
    val allSky=repository.getAllSky()
    val allWind=repository.getAllWind()
    val allPrecipitation = repository.getAllPrecipitation()
    val allLeaders = repository.getAllLeaders()
    val allObservers = repository.getAllObservers()
    var morningSurvey : MorningSurvey = MorningSurvey(null,"","",null,null,null,"","","")


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

    //fun getAllSky() : LiveData<List<Sky>>? {
       // return repository.getAllSky()
   // }

   /* fun getAllPrecipitation() : LiveData<List<Precipitation>>? {
        return repository.getAllPrecipitation()
    }

    fun getAllWind() : LiveData<List<Wind>>? {
        return repository.getAllWind()
    }*/

    fun login(email:String, password:String) {
       val users = getUser(email)
        if(users.size<=0) {
            loggedIn.value=false
        } else {
            val user = users[0]
            val pass = user.Password
            if (pass == password) {
                loggedIn.value = true
                setUserSurvey(user)
            }
        }
       // val user1 = user.value
        //loggedIn.value = user?.Password==password
    }

    fun setBeachSurvey(par:Any) {
        if(par is Beach) {
            morningSurvey.Beach = par.Name
        }
    }

    fun setUserSurvey(par:User) {
        morningSurvey.User=par.userId
    }

    fun setSectorSurvey(par:Any) {
        if(par is BeachSector) {
            morningSurvey.Sector=par.Name
        }
    }

    fun setWindSurvey(par: Any) {
        if (par is Wind) {
            morningSurvey.Wind=par.Intensity
        }
    }

    fun setSkySurvey(par: Any) {
        if (par is Sky) {
            morningSurvey.Sky=par.Condition
        }
    }

    fun setPrecipitationSurvey(par: Any) {
        if (par is Precipitation) {
            morningSurvey.Precipitation=par.Precipitation
        }
    }

    fun setLeadersSurvey(par: Any) {
        if (par is Leaders) {
            morningSurvey.Leader=par.id
        }
    }

    fun setObserversSurvey(par: Any) {
        if (par is Observers) {
            morningSurvey.Second=par.id
        }
    }

    fun getTimeStamp() :String{
        val millisec:Long =System.currentTimeMillis()
        morningSurvey.Timestamp=millisec
        val simpleDateFormat : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm")
        val cDate =Date(millisec)
        return simpleDateFormat.format(cDate)
    }

    fun cancel() {
        this.morningSurvey=MorningSurvey(morningSurvey.User,"","",null,null,null,"","","")
    }

    fun submit() {
        repository.insertSurvey(morningSurvey)
    }



}


