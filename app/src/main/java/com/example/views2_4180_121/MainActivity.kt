package com.example.views2_4180_121

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

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
        val convText: TextView = findViewById(R.id.convRes)
        val inputText: TextInputEditText = findViewById(R.id.tempInput)
        val reset: Button = findViewById(R.id.button)
        val calc: Button = findViewById(R.id.button2)
        val c2f: RadioButton = findViewById(R.id.cTof)
        val f2c: RadioButton = findViewById(R.id.fToc)

        calc.setOnClickListener {
            Toast.makeText(this, "Please enter a temperature to convert", Toast.LENGTH_LONG).show()
        }


        c2f.setOnCheckedChangeListener { _, _ ->
            calc.setOnClickListener {
                calc.setOnClickListener {
                    try {
                        val temp: Float = inputText.text.toString().toFloat()
                        val conv: Float = (temp - 32) * 5/9
                        val txt = "${conv}C"
                        convText.text = txt
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        f2c.setOnCheckedChangeListener { _, _ ->
            calc.setOnClickListener {
                try {
                    val temp: Float = inputText.text.toString().toFloat()
                    val conv: Float = (temp * 9/5) + 32
                    val txt = "${conv}F"
                    convText.text = txt
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

        reset.setOnClickListener {
            convText.text = "N/A"
            inputText.text?.clear()
        }

    }
}