package com.example.jogodavelha.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jogodavelha.data.Matriz

class MainActivityViewModel: ViewModel() {
    var matriz = Matriz()
    var player = "X"

}