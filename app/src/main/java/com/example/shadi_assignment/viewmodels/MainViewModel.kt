package com.example.shadi_assignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import com.example.shadi_assignment.models.modelsNew
import com.example.shadi_assignment.repository.ShadiRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ShadiRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getData(10)
        }
    }

    val data : LiveData<modelsNew>
        get() = repository.data
}