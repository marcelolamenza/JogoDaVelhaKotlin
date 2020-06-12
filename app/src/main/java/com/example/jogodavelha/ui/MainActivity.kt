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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.viewModel = viewModel

        setupObservers()

    }

    private fun setupObservers() {
        viewModel.buttonCoordinate.observe(this, Observer {
            binding.winnerMessage = it.first
            binding.isEnable = it.second
        })
    }

    companion object {
        private const val TAG = "MyActivity"
    }

}