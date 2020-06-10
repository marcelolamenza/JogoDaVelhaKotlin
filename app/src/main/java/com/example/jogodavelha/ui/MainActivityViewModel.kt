package com.example.jogodavelha.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jogodavelha.data.Matriz

class MainActivityViewModel: ViewModel() {

    private var buttonCoordinate_: MutableLiveData<Int> = MutableLiveData()
    var buttonCoordinate: LiveData<Int> = buttonCoordinate_
    var gameWon: MutableLiveData<Boolean> = MutableLiveData()


    var player = "X"
    var matrizViewModel = Matriz()

    init {
        gameWon.value = false
    }

    fun onButtonClick(buttonCoordinate: Int){
        buttonCoordinate_.value = buttonCoordinate
        matrizViewModel.changeNumber(buttonCoordinate, player)
        if(matrizViewModel.checkWinCondition()) {

        }else{
            changeTurn()
        }

    }

    fun changeTurn(){
        player = if(player == "X"){
            "O"
        }else{
            "X"
        }
    }
}