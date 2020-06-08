package com.example.jogodavelha.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.jogodavelha.data.Matriz
import com.example.jogodavelha.R
import com.example.jogodavelha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var name: String
    var matriz = Matriz()



    //Define qual o jogador deve jogar (X ou O)
    var player: String = "O"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.main?.name = "oi"

        //binding.playerTurn.text = "funciona"

        //setObservers()
        //setListeners()
    }

    private fun setListeners() {

    }

    fun setObservers(){

    }

    fun onClickButton(i : Int, j : Int){
        matriz.button_array[i][j] = player
        Toast.makeText(this,"ENTROU", Toast.LENGTH_SHORT).show()
    }



}