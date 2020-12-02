package com.nabin.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirst: EditText = findViewById(R.id.etFirst)
        val etSecond : EditText = findViewById(R.id.etSecond)
        val btnCalculate : Button = findViewById(R.id.btnCalculate)
        val tvResult : TextView = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val first = etFirst.text.toString().toInt()
            val second = etSecond.text.toString().toInt()
            val result = first + second
            Toast.makeText(this, "The sum is $result", Toast.LENGTH_SHORT).show()

            tvResult.text= result.toString()
        }
    }
}