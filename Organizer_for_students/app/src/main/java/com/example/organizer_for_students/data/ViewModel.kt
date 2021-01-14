package com.example.organizer_for_students.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class WordViewModel(private val repository: OrganizerRepository) : ViewModel() {

    val allProfessors: LiveData<List<Professor>> = repository.allProfessors.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(professor: Professor) = viewModelScope.launch {
        repository.insert(professor)
    }
}

class WordViewModelFactory(private val repository: OrganizerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}