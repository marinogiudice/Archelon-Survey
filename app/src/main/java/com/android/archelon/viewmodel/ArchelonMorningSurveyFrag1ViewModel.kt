package com.android.archelon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.archelon.entities.Beach
import com.android.archelon.repository.ArchelonRepository

class ArchelonMorningSurveyFrag1ViewModel (private val repository: ArchelonRepository) : ViewModel() {

    fun getAllBeach() : LiveData<List<Beach>>? {
        return repository.getAllBeach()
    }
}