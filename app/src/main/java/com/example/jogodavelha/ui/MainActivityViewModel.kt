package com.example.jogodavelha.ui

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jogodavelha.BR
import com.example.jogodavelha.data.Matriz

class MainActivityViewModel: BaseObservable() {

    private var buttonCoordinate_: MutableLiveData<Pair<String,Boolean>> = MutableLiveData()
    var buttonCoordinate: LiveData<Pair<String,Boolean>> = buttonCoordinate_

    var matrizViewModel = Matriz()
    var currentPlayerString = PLAYER_ONE
    var currentPlayerToShow = "Player $currentPlayerString"
    var winner = ""
    var isEnable = true

    companion object {
        const val PLAYER_ONE = "X"
        const val PLAYER_TWO = "O"
    }

    init {
        buttonCoordinate_.value = Pair(winner,isEnable)
    }

    fun onButtonClick(buttonCoordinate: Int) {
        matrizViewModel.changeNumber(buttonCoordinate, currentPlayerString)
        Log.d("Teste",matrizViewModel.toString())
        if(matrizViewModel.checkWinCondition()) {
            setWinner()
        }else{
            changeTurn()
        }

    }

    private fun setWinner() {
        Log.d("Teste","Winner, player $currentPlayerString")
        winner = "PLAYER $currentPlayerString WIN"
        isEnable = false
        buttonCoordinate_.value = Pair(winner,isEnable)
    }

    fun onClickButton(view: View, coordenate : Int){
        (view as Button).apply {
            this.isClickable = false
            this.text = currentPlayerString
        }
        onButtonClick(coordenate)
    }

    private fun reset() {
        isEnable = true
        winner = ""
        currentPlayerString = PLAYER_ONE
        buttonCoordinate_.value = Pair(winner,isEnable)
        matrizViewModel.resetMatriz()

    }

    fun changeTurn(){
        currentPlayerString = when(currentPlayerString) {
            PLAYER_ONE -> PLAYER_TWO
            PLAYER_TWO -> PLAYER_ONE
            else -> ""
        }
        setCurrentPlayer("Player $currentPlayerString")
    }

    @Bindable
    fun getCurrentPlayer(): String {
        return currentPlayerToShow
    }

    @Bindable
    fun setCurrentPlayer(current: String) {
        if(currentPlayerToShow != current) {
            currentPlayerToShow = current

            notifyPropertyChanged(BR.currentPlayer)
        }
    }



}