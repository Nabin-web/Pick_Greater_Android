package com.nabin.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlin.random.Random

class game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosehigher)

        val btnFirst: Button = findViewById(R.id.btnFirst)
        val btnSecond: Button = findViewById(R.id.btnSecond)
        val tvCorrect: TextView = findViewById(R.id.tvCorrect)
        val tvIncorrect: TextView = findViewById(R.id.tvIncorrect)
        val btnRestart: Button = findViewById(R.id.btnRestart)


        var correct = 0
        var incorrect = 0
        var counter = correct + incorrect

        fun gen(){
            var counter : Int = correct + incorrect
            val f = randomNum()
            btnFirst.text= f.toString()
            val s= randomNum()
            btnSecond.text = s.toString()

            if (btnFirst==btnSecond){
                btnSecond.text= randomNum().toString()
            }

            if (counter==10){
                tvCorrect.isVisible= true
                tvIncorrect.isVisible= true
                btnFirst.isClickable= false
                btnSecond.isClickable= false

                if ((correct>incorrect) || (correct==5)){
                    Toast.makeText(this , "You win with correct score $correct", Toast.LENGTH_LONG).show()
                    tvCorrect.text = correct.toString()
                    tvIncorrect.text = incorrect.toString()
                }
                else{
                    Toast.makeText(this , "You lose with score $incorrect", Toast.LENGTH_LONG).show()
                }



            }

        }


        btnRestart.setOnClickListener {
            correct=0
            incorrect=0
            tvCorrect.isVisible = false
            tvIncorrect.isVisible= false
            btnFirst.isClickable= true
            btnSecond.isClickable= true

        }




            btnFirst.setOnClickListener {
                btnFirst.text = randomNum().toString()
                btnSecond.text = randomNum().toString()
                val firstBtn = btnFirst.text.toString().toInt()
                val secondBtn = btnSecond.text.toString().toInt()
                if (firstBtn > secondBtn) {
                    correct += 1

                } else {
                    incorrect += 1

                }
                gen();
            }


            btnSecond.setOnClickListener {
                btnFirst.text = randomNum().toString()
                btnSecond.text = randomNum().toString()
                val firstBtn = btnFirst.text.toString().toInt()
                val secondBtn = btnSecond.text.toString().toInt()
                if (firstBtn < secondBtn) {
                    correct += 1

                } else {
                    incorrect += 1

                }

                gen();


            }


            //  }


        }


    private fun randomNum(): Int {
        return Random.nextInt(0, 100)
    }
}
