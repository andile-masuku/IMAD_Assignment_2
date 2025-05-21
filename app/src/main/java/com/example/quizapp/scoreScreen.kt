package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class scoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val pointsTextView = findViewById<TextView>(R.id.total)
        val responseTextView = findViewById<TextView>(R.id.answer)
        val reviewBtn = findViewById<Button>(R.id.review)
        val extBtn = findViewById<Button>(R.id.extBtn)

        val points = intent.getIntExtra("points",0)
        pointsTextView.text = "Your points are: $points/10"

        val response = if (points >= 5 ) {
            "Well Done :)"
        }else{
            "You can Still Do Better keep up"
        }
        responseTextView.text = response

        reviewBtn.setOnClickListener {

            val intent = Intent(this, review::class.java )
            intent.putExtra("askedQuestions", quiz_question.askedquestions)
            intent.putExtra("results", quiz_question.results)
            startActivity(intent)
        }
        extBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }


    }
}