package com.android.archelon.viewmodel

import android.icu.text.SimpleDateFormat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.archelon.entities.*
import com.android.archelon.repository.ArchelonRepository
import java.util.*

/**
 *  ArchelonViewModel Class is the ViewModel used in the application
 *  Takes as parameter the repository.
 *  Uses Repository methods calls to Load data.
 *  Holds Public variables that can be accessed and Observed by the view.
 *
 */
class ArchelonViewModel (private val repository: ArchelonRepository) : ViewModel() {

    //holds the state of the user log-in
    val loggedIn = MutableLiveData<Boolean>(false)
    //holds the list of all the Beach
    val beaches=repository.getAllBeach()
    //Holds the list of all The beach Sector
    val allBeachSector=repository.getAllSector()
    //Holds the list of all the Sky Conditions
    val allSky=repository.getAllSky()
    //Hold The list of all The Wind Intensiy
    val allWind=repository.getAllWind()
    //Holds The List of All the precipitations
    val allPrecipitation = repository.getAllPrecipitation()
    //Hold the List of all the Survey Leaders
    val allLeaders = repository.getAllLeaders()
    //Holds the list of all the 2nd Observers
    val allObservers = repository.getAllObservers()
    //Holds The mornignSurvey Object that will be used to contain the user choice through the Survey
    var morningSurvey : MorningSurvey = MorningSurvey(null,"","",null,null,null,"","","")

    //insert a user
    fun insertUser(user: User) {
        repository.insertUser(user)
    }

    //returns a list of user with the corrisponding email from the repository
    fun getUser(email:String) : List<User> {
        return repository.getUser(email)
    }

    /*
        Executes the login process.
        Checks if a user with email and password corresponding to the method's
        parameters is in the repository.
        If yes set the MutableLiveData loggedIn as true
        Set the field of the morningSurvey Object as true

     */

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

    /*
        Sets the morningSurvey object Beach.
        Takes an "Any" as parameter. If par is of type Beach
        morningSurvey is set
        returns nothing
     */

    fun setBeachSurvey(par:Any) {
        if(par is Beach) {
            morningSurvey.beach = par.beachName
        }
    }

    /*
        Sets the morningSurvey object userId.
        Takes an "User" as parameter. Is Used
        in the login method
        returns nothing
     */

    fun setUserSurvey(par:User) {
        morningSurvey.userId=par.userId
    }

    /*
        Sets the morningSurvey object beachSector.
        Takes an "Any" as parameter. If par is of type BeachSector
        morningSurvey is set
        returns nothing
     */

    fun setSectorSurvey(par:Any) {
        if(par is BeachSector) {
            morningSurvey.beachSector=par.sectorName
        }
    }

    /*
        Sets the morningSurvey object wind.
        Takes an "Any" as parameter. If par is of type Wind
        morningSurvey is set
        returns nothing
     */

    fun setWindSurvey(par: Any) {
        if (par is Wind) {
            morningSurvey.wind=par.intensity
        }
    }

    /*
        Sets the morningSurvey object sky.
        Takes an "Any" as parameter. If par is of type Sky
        morningSurvey is set
        returns nothing
     */

    fun setSkySurvey(par: Any) {
        if (par is Sky) {
            morningSurvey.sky=par.condition
        }
    }

    /*
        Sets the morningSurvey object  precipitation.
        Takes an "Any" as parameter. If par is of type Precipitation
        morningSurvey is set
        returns nothing
     */

    fun setPrecipitationSurvey(par: Any) {
        if (par is Precipitation) {
            morningSurvey.precipitation=par.precipitation
        }
    }

    /*
        Sets the morningSurvey object leaderId.
        Takes an "Any" as parameter. If par is of type Leader
        morningSurvey is set
        returns nothing
     */

    fun setLeadersSurvey(par: Any) {
        if (par is Leaders) {
            morningSurvey.leaderId=par.leaderId
        }
    }

    /*
        Sets the morningSurvey object secondObs.
        Takes an "Any" as parameter. If par is of type Observers
        morningSurvey is set
        returns nothing
     */

    fun setObserversSurvey(par: Any) {
        if (par is Observers) {
            morningSurvey.secondObs=par.secondObsId
        }
    }

    /*
        Obtains the "Long" timestamp from the system clock.
        Returns a String, The long value in a human readable format
        sets the morningSurvey object timestamp
     */

    fun getTimeStamp() :String{
        val millisec:Long =System.currentTimeMillis()
        morningSurvey.timestamp=millisec
        val simpleDateFormat  = SimpleDateFormat("dd-MM-yyyy HH:mm")
        val cDate =Date(millisec)
        return simpleDateFormat.format(cDate)
    }

    /*
        Reset the morningSurvey objectas would have just been created.
        Used in the UI cancel Button
        Returns nothing
     */

    fun cancel() {
        this.morningSurvey=MorningSurvey(morningSurvey.userId,"","",null,null,null,"","","")

    }

    /*
        Insert the morningSurvey object in the repository
        Used in the "step3" of morninSurvey when in the UI
        The User press the submit button
     */

    fun submit() {
        repository.insertSurvey(morningSurvey)
    }



}


