package com.example.emptyviews_screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterScreen : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        val emailEdt = findViewById<EditText>(R.id.editEmailReg)
        val passwordEdt = findViewById<EditText>(R.id.editPasswordReg)
        val registerBtn = findViewById<Button>(R.id.button_Reg)
        val genderGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val countrySpinner = findViewById<Spinner>(R.id.spinnerCountry)
        val termsCheck = findViewById<CheckBox>(R.id.checkTerms)
        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val countries = arrayOf("Select Country", "Pakistan", "India", "USA", "UK")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySpinner.adapter = adapter
        registerBtn.setOnClickListener {

            val email = emailEdt.text.toString()
            val password = passwordEdt.text.toString()
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val selectedCountry = countrySpinner.selectedItem.toString()
            if (email.isEmpty()) {
                emailEdt.error = "Email is required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordEdt.error = "Password is required"
                return@setOnClickListener
            }
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (selectedCountry == "Select Country") {
                Toast.makeText(this, "Please select country", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!termsCheck.isChecked) {
                Toast.makeText(this, "Accept Terms & Conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save credentials
            sharedPreferences.edit().apply {
                putString(EMAIL_KEY, email)
                putString(PASSWORD_KEY, password)
                apply()
            }
            Toast.makeText(this, "Registration Successful! Please login.", Toast.LENGTH_SHORT).show()

            // Move to LoginScreen and prevent back navigation
            val intent = Intent(this, LoginScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)



        }
    }
}