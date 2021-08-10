package com.example.bmiapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bmiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "TTT"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calcBMI(v: View) {
        if (binding.editTextNumberDecimalHeight.text.isNotEmpty() && binding.editTextNumberDecimalWeight.text.isNotEmpty()) {
            val M = binding.editTextNumberDecimalWeight.text.toString().toFloat();
            val I = binding.editTextNumberDecimalHeight.text.toString().toFloat();
            binding.editTextNumberDecimalWeight.text.clear()
            binding.editTextNumberDecimalHeight.text.clear()
            BMI(I, M)
        }

    }

    fun BMI(I: Float, M: Float) {
        val result = M / (I * I)
        var resultText = ""
        var resultResID: Int
        binding.textViewResult.text = String.format("%.2f", result)
        if (result < 18.5) {
            resultText = getString(R.string.underweight)
            resultResID = R.drawable.underweight
        } else if (result < 25 && result >= 18.5) {
            resultText = getString(R.string.normal_weight)
            resultResID = R.drawable.healthy
        } else if (result < 30 && result >= 25) {
            resultText = getString(R.string.over_weight)
            resultResID = R.drawable.overweight
        } else if (result < 35 && result >= 30) {
            resultText = getString(R.string.obesity_class_1)
            resultResID = R.drawable.obesity
        } else if (result < 39.9 && result >= 35) {
            resultText = getString(R.string.obesity_class_2)
            resultResID = R.drawable.obesity
        } else {
            resultText = getString(R.string.obesity_class_3)
            resultResID = R.drawable.obesity
        }
        binding.textViewBMIndex.text = resultText
        binding.imageBMI.setImageResource(resultResID)
    }
}