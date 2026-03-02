package com.example.bmi_calculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
       val bmi = intent.getFloatExtra("result_bmi", 0f)
        val name = intent.getStringExtra("user_name")
        val age = intent.getStringExtra("user_age")
        val result: TextView= findViewById(R.id.Result)
        result.text = bmi.toString()
        result.text = "Name: $name\nAge: $age\nBMI: ${String.format("%.2f", bmi)}"
        val resultColor = when
        {
            bmi < 18.5 -> R.color.underweight
            bmi >= 18.5 && bmi < 25 -> R.color.normal
            bmi >= 25  -> R.color.overweight
            else -> R.color.obese

        }
        val actualcolor = androidx.core.content.ContextCompat.getColor(this,resultColor)
result.setTextColor(actualcolor)


    }
}