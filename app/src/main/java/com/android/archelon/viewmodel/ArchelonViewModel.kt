package com.android.archelon.viewmodel

import android.icu.text.SimpleDateFormat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.archelon.entities.*
import com.android.archelon.repository.ArchelonRepository
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


    fun insertUser(user: User) {
        repository.insertUser(user)
    }

    fun getUser(email:String) : List<User> {
        return repository.getUser(email)
    }

    fun login(email:String, password:String) {
       val users = getUser(email)
        if(users.size<=0) {
            loggedIn.value=false
        } else {
            val user = users[0]
            val pass = user.password
            if (pass == password) {
                loggedIn.value = true
                setUserSurvey(user)
            }
        }
    }

    fun setBeachSurvey(par:Any) {
        if(par is Beach) {
            morningSurvey.beach = par.beachName
        }
    }

    fun setUserSurvey(par:User) {
        morningSurvey.userId=par.userId
    }

    fun setSectorSurvey(par:Any) {
        if(par is BeachSector) {
            morningSurvey.beachSector=par.sectorName
        }
    }

    fun setWindSurvey(par: Any) {
        if (par is Wind) {
            morningSurvey.wind=par.intensity
        }
    }

    fun setSkySurvey(par: Any) {
        if (par is Sky) {
            morningSurvey.sky=par.condition
        }
    }

    fun setPrecipitationSurvey(par: Any) {
        if (par is Precipitation) {
            morningSurvey.precipitation=par.precipitation
        }
    }

    fun setLeadersSurvey(par: Any) {
        if (par is Leaders) {
            morningSurvey.leaderId=par.leaderId
        }
    }

    fun setObserversSurvey(par: Any) {
        if (par is Observers) {
            morningSurvey.secondObs=par.secondObsId
        }
    }

    fun getTimeStamp() :String{
        val millisec:Long =System.currentTimeMillis()
        morningSurvey.timestamp=millisec
        val simpleDateFormat  = SimpleDateFormat("dd-MM-yyyy HH:mm")
        val cDate =Date(millisec)
        return simpleDateFormat.format(cDate)
    }

    fun cancel() {
        this.morningSurvey=MorningSurvey(morningSurvey.userId,"","",null,null,null,"","","")
    }

    fun submit() {
        repository.insertSurvey(morningSurvey)
    }



}


