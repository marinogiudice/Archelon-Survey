package com.android.archelon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.archelon.database.User
import com.android.archelon.repository.ArchelonRepository

class ArchelonViewModel(private val repository: ArchelonRepository) : ViewModel() {
    var LiveDataUser: LiveData<User>?=null

    fun getUser(email:String):LiveData<User>? {
        LiveDataUser=repository.getUser(email)
        return LiveDataUser
    }

    override fun onCleared() {
        super.onCleared()
    }

}