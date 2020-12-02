package com.nabin.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_si)

        val etPrinciple: EditText = findViewById(R.id.etPrinciple)
        val etRate : EditText = findViewById(R.id.etRate)
        val etTime :EditText = findViewById(R.id.etTime)
        val btnSi: Button = findViewById(R.id.btnIntrest)
        val tvSi : TextView = findViewById(R.id.tvSi)

        btnSi.setOnClickListener {
            val principle = etPrinciple.text.toString().toInt()
            val rate = etRate.text.toString().toInt()
            val time = etTime.text.toString().toInt()

            val simpleIntrest = (principle * rate * time) / 100

            Toast.makeText(this, "The simple intrest is $simpleIntrest ", Toast.LENGTH_SHORT).show()
            tvSi.text = simpleIntrest.toString()
        }

    }
}