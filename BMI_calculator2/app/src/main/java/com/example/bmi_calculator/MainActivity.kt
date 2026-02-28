package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textHeight:EditText = findViewById(R.id.height)
        val textName:EditText = findViewById(R.id.name)
        val textAge:EditText = findViewById(R.id.age)
        val textWeight:EditText = findViewById(R.id.weight)
         val buttonSubmit: Button = findViewById(R.id.button1)
        buttonSubmit.setOnClickListener {
//            string conversiions
            val namestring = textName.text.toString().trim()
            val agestring= textAge.text.toString().trim()
            var heightstring = textHeight.text.toString().trim()
            val weightstring = textWeight.text.toString().trim()
            if (namestring.isEmpty()) {
                textName.error = "Name is required"
                return@setOnClickListener
            }
            if (agestring.isEmpty()) {
                textAge.error = "Age is required"
                return@setOnClickListener
            }
            val age = agestring.toIntOrNull()
            if (age == null || age <= 0) {
                textAge.error = "Age is not valid"
                return@setOnClickListener
            }
            if (weightstring.isEmpty()) {
                textWeight.error = "Weight is required"
                return@setOnClickListener
            }
                val weight = weightstring.toFloatOrNull()
                if (weight == null) {
                    textWeight.error = "Weight must be a number"
                    return@setOnClickListener
                }
            if (heightstring.isEmpty()) {
                textHeight.error = "Height is required"
                return@setOnClickListener
            }
                var height = heightstring.toFloatOrNull()
                if (height == null) {
                    textHeight.error = "Height must be a number"
                    return@setOnClickListener
                }
            // BMI calculation
            height /= 100
            val bmi = weight / (height * height)
val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result_bmi", bmi)
            intent.putExtra("user_name", namestring)
            intent.putExtra("user_age", agestring)
            startActivity(intent)

        }

    }
}