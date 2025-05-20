package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.icu.util.Output
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quiz_question : AppCompatActivity() {

    private lateinit var quesOutput: TextView
    private lateinit var trueBtn: Button
    private lateinit var falseBtn: Button
    private lateinit var replyTextView: TextView
    private lateinit var nxtBtn: Button
    private lateinit var backBtn: Button

    private var score = 0
    private var questionCell = 0

    companion object {
        val askedquestions = arrayOf(

            "Was Kotlin primarily designed for Data analysis?",
            "The developer of the Kotlin language is The JetBrains.",
            "An array is used to store multiple values as a single value.",
            "Private is used in Kotlin for other user to see your code.",
            "Textview is used to output or display a text/ massage.",
            "The XML file is used to create a function for an app.",
            "Android Studio is used to develop iOS apps for Apple.",
            "Blue stacks is usually used as a Virtual device to run apps from Android Studio.",
            "An app can not run on Android Studio if there is no Function.",
            "Android Studio only allows the user to only create Four screens maximum"

        )
        val results = booleanArrayOf(false,true,true,false,true,false,false,true,false,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_question)

        quesOutput = findViewById(R.id.quesOutput)
        replyTextView = findViewById(R.id.replyText)
        trueBtn = findViewById(R.id.trueBtn)
        falseBtn = findViewById(R.id.falseBtn)
        nxtBtn = findViewById(R.id.nxtBtn)
        backBtn = findViewById(R.id.backBtn)

        showQuestion()

        trueBtn.setOnClickListener { check(true) }
        falseBtn.setOnClickListener { check(false) }

        nxtBtn.setOnClickListener {
            questionCell+1
            if (askedquestions.size > questionCell){
                showQuestion()

                falseBtn.isEnabled = true
                trueBtn.isEnabled = true
                replyTextView.text = ""
            }else {

                val intent = Intent(this, scoreScreen::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
            backBtn.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        nxtBtn.isEnabled = false

    }

    private fun showQuestion() {
       quesOutput.text = askedquestions[questionCell]
    }
    private fun responseCheck (inputResponse: Boolean) {
        val correctResponse = results[questionCell]

        if (inputResponse == correctResponse) {
            replyTextView.text = "Good Job :)"
            replyTextView.setTextColor(Color.BLUE)
            score+1
        }else {
            replyTextView.text = " You can do better :("
        }
        trueBtn.isEnabled = false
        falseBtn.isEnabled = false
        nxtBtn.isEnabled = true
    }

}

