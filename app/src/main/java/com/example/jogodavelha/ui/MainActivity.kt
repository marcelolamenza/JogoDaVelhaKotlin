package com.example.jogodavelha.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.jogodavelha.data.Matriz
import com.example.jogodavelha.R
import com.example.jogodavelha.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    val viewModel: MainActivityViewModel = MainActivityViewModel()
    var phase = "Player ${viewModel.player}"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.main = this
        setObservers()
    }

    fun setObservers(){
        viewModel.gameWon.observe(this, Observer {
            if(it){
                phase = "PLAYER ${player_turn} HAS WON THE GAME"
            }
        })

        viewModel.buttonCoordinate.observe(this, Observer {
            Log.i(TAG, viewModel.matrizViewModel.toString())
            when(viewModel.buttonCoordinate.value){
                1 -> {
                    binding.btnLeftTop.text = viewModel.player
                    binding.btnLeftTop.isClickable = false
                }
                2 -> {
                    binding.btnCenterTop.text = viewModel.player
                    binding.btnCenterTop.isClickable = false
                }
                3 -> {
                    binding.btnRightTop.text = viewModel.player
                    binding.btnRightTop.isClickable = false
                }
                4 -> {
                    binding.btnLeftCenter.text = viewModel.player
                    binding.btnLeftCenter.isClickable = false
                }
                5 -> {
                    binding.btnCenterCenter.text = viewModel.player
                    binding.btnCenterCenter.isClickable = false
                }
                6 -> {
                    binding.btnRightCenter.text = viewModel.player
                    binding.btnRightCenter.isClickable = false
                }
                7 -> {
                    binding.btnRightBottom.text = viewModel.player
                    binding.btnRightBottom.isClickable = false
                }
                8 -> {
                    binding.btnCenterBottom.text = viewModel.player
                    binding.btnCenterBottom.isClickable = false
                }
                9 -> {
                    binding.btnLeftBottom.text = viewModel.player
                    binding.btnLeftBottom.isClickable = false
                }
            }
        })

    }

    fun onClickButton(coordenate : Int){
        viewModel.onButtonClick(coordenate)
        if(!viewModel.gameWon.value!!){
            phase = "Player ${viewModel.player}"
        }
        bindingObj()
    }

    fun bindingObj(){
        binding.main = this
    }

    companion object {
        private const val TAG = "MyActivity"
    }

}