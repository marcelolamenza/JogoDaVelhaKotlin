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
        matrizViewModel.changeNumber(buttonCoordinate, player)
        buttonCoordinate_.value = buttonCoordinate

        if(matrizViewModel.checkWinCondition()) {
            gameWon.value = true
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