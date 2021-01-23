package com.android.archelon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.archelon.entities.User
import com.android.archelon.repository.ArchelonRepository
import kotlinx.coroutines.launch

class ArchelonViewModel (private val repository: ArchelonRepository) : ViewModel(){

    fun getUser(email:String) : LiveData<List<User>>? {
        return repository.getUser(email)
    }

    override fun onCleared() {
        super.onCleared()
    }



}