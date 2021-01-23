package com.android.archelon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.archelon.entities.*
import com.android.archelon.repository.ArchelonRepository
import kotlinx.coroutines.launch

class ArchelonViewModel (private val repository: ArchelonRepository) : ViewModel(){

    val loggedIn = MutableLiveData<Boolean>(false)


    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun getUser(email:String) : LiveData<List<User>> {
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
        val user   = getUser(email).value!!.get(0)

    }



}


