package com.example.emptyviews_screen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginScreen : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        val emailEditText = findViewById<EditText>(R.id.EditEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextNumberPassword)
        val loginButton = findViewById<Button>(R.id.button_login)

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString(EMAIL_KEY, null)
        val savedPassword = sharedPreferences.getString(PASSWORD_KEY, null)
        loginButton.setOnClickListener {

            val name = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

if (name.isEmpty() || password.isEmpty())
{
    Toast.makeText(this, "Please Enter your Credentials", Toast.LENGTH_SHORT).show()
}
            else if (name == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

    }
}