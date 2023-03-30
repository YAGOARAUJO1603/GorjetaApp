package com.hugoyago.gorjetaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.hugoyago.gorjetaapp.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip() {
        val stringInTextField = binding.Cost.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.opcoes.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.amazing -> 0.20
            R.id.good -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundup.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.TipAmount.text = getString(R.string.tip_amount, formattedTip)
    }
}