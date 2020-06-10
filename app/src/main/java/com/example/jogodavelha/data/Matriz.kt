package com.example.jogodavelha.data

class Matriz{

    private var array1 = mutableListOf(" "," "," ")
    private var array2 = mutableListOf(" "," "," ")
    private var array3 = mutableListOf(" "," "," ")
    var button_array = mutableListOf(array1,array2,array3)
    private var row: Int = 0
    private var i: Int = 0

    fun changeNumber(buttonCoordinate: Int, turn:String){
        i = whichRow(buttonCoordinate)
        when(row){
            1 -> array1[i] = turn
            2 -> array2[i] = turn
            3 -> array3[i] = turn
        }
    }

    override fun toString(): String {
        
        return super.toString()
    }

    private fun whichRow(v:Int): Int{
        return when (v) {
            in 1..3 -> {
                row = 1
                return (v - 1)
            }
            in 4..6 -> {
                row = 2
                return (v - 4)
            }
            in 4..6 -> {
                row = 3
                return (v - 7)
            }
            else -> 0
        }
    }

    fun checkWinCondition(): Boolean{
        for (i in 0..2){
            if(button_array[i][0] == button_array[i][1] && button_array[i][1] == button_array[i][2] && notNull(button_array[i][0])){
                return true
            }
            if(button_array[0][i] == button_array[1][i] && button_array[1][i] == button_array[2][i] && notNull(button_array[0][i])){
                return true
            }
        }
        if(button_array[0][0] == button_array[1][1] && button_array[1][1] == button_array[2][2] && notNull(button_array[1][1])){
            return true
        }
        if(button_array[2][0] == button_array[1][1] && button_array[1][1] == button_array[2][0] && notNull(button_array[1][1])){
            return true
        }
        return false
    }

    private fun notNull(item: String): Boolean{
        return item != " "
    }
}

