package com.android.archelon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.archelon.repository.ArchelonRepository

/**
 * Provides the ArchelonViewModel Objects Factory
 * takes the repository as parameter
 * I Used Google Android Developer Website as pointer.
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin#9
 */

class ArchelonViewModelFactory(private val repository: ArchelonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ArchelonRepository::class.java).newInstance(repository)
    }
}