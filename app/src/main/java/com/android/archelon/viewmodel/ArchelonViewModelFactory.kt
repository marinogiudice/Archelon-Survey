package com.android.archelon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.archelon.repository.ArchelonRepository

class ArchelonViewModelFactory(private val repository: ArchelonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ArchelonRepository::class.java).newInstance(repository)
    }
}