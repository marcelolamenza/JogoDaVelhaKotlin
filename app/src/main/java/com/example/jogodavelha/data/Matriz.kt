package com.example.jogodavelha.data

class Matriz{

    private var array1 = arrayOf(" "," "," ")
    private var array2 = arrayOf(" "," "," ")
    private var array3 = arrayOf(" "," "," ")
    var button_array = arrayListOf(array1,array2,array3)
    private var row: Int = 0
    private var i: Int = 0

    fun changeNumber(buttonCoordinate: Int, PlayerTurn:String){
        i = whichRow(buttonCoordinate)
        when(row){
            0 -> array1[i] = PlayerTurn
            1 -> array2[i] = PlayerTurn
            2 -> array3[i] = PlayerTurn
        }
    }

    private fun whichRow(v:Int): Int{
        return when (v) {
            in 1..3 -> {
                row = 0
                return (v - 1)
            }
            in 4..6 -> {
                row = 1
                return (v - 4)
            }
            in 7..9 -> {
                row = 2
                return (v - 7)
            }
            else -> 0
        }
    }

    override fun toString(): String {
        var fullArray = ""
        fullArray = "a\n|${array1[0]} |${array1[1]} |${array1[2]}|\n|${array2[0]} |${array2[1]} |${array2[2]}|\n|"+
                "${array3[0]} |${array3[1]} |${array3[2]}"
        return fullArray
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
        if(button_array[2][0] == button_array[1][1] && button_array[1][1] == button_array[0][2] && notNull(button_array[1][1])){
            return true
        }
        return false
    }


    private fun notNull(item: String): Boolean{
        return item != " "
    }

    fun resetMatriz() {
        array1 = arrayOf(" "," "," ")
        array2 = arrayOf(" "," "," ")
        array3 = arrayOf(" "," "," ")
    }




}

