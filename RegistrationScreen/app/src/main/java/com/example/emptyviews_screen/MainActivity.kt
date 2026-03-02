package com.example.emptyviews_screen
import android.os.Bundle
import android.view.View
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
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText = findViewById<EditText>(R.id.user_input)

        val button = findViewById<Button>(R.id.show_text)
        val text = findViewById<TextView>(R.id.user_text)
        button.setOnClickListener {
            val userText = editText.text.toString()
//            var number = editText.toDoubleOrNull()
//
//            if (number.isEmpty())
//            {
//
//                text.text = userText
//                text.visibility = View.VISIBLE
//            }
//            else if (number.isNotEmpty())
//                {
//                number = number * 3.00
//                text.text = number.toString()
//                text.visibility = View.VISIBLE
//            }
//


        }

        val clearButton = findViewById<Button>(R.id.clear_text)
        clearButton.setOnClickListener {
            editText.text.clear()
            text.text = ""
            text.visibility = View.INVISIBLE

        }
        // discount button logic

        val Disbutton = findViewById<Button>(R.id.show_text)
        Disbutton.setOnClickListener {
            val userText = editText.text.toString()
            var number = userText.toDoubleOrNull()
            if (number.toString().isNotEmpty()) {
                number = number!! * 0.2
                text.text = number.toString()
                text.visibility = View.VISIBLE

            }


        }
    }
    }
