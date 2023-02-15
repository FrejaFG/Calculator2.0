package com.example.calculator20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonCalculate.setOnClickListener {
            calculate()
        }

    }

    private fun calculate() {
        val number1str = binding.editTextNumber1.text.toString().trim()
        val number2str = binding.editTextNumber2.text.toString().trim()
        var error = false
        if (number1str.isEmpty()) {
            binding.editTextNumber1.error = "no number"
            error = true
        }
        if (number2str.isEmpty()) {
            binding.editTextNumber2.error = "no number"
            error = true
        }
        if (error) return
        val number1 = number1str.toDouble()
        val number2 = number2str.toDouble()
        var result = 0.0
        val operation = binding.spinnerOperations.selectedItem as String
        when (operation) {
            "+" -> result = number1+number2
            "-" -> result = number1-number2
            "*" -> result = number1*number2
            "/" -> result = number1/number2
        }
        val resultStr = result.toString()
        binding.textViewResult.text=resultStr
    }
}