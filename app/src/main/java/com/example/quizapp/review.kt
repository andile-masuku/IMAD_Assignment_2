package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R.id.endBtn
import kotlin.system.exitProcess

class review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)


        val resultTextView =findViewById<TextView>(R.id.review_Text)
        val rePlayBtn = findViewById<Button>(R.id.rePlay)
        val extBtn = findViewById<Button>(endBtn)
        
        val askedquestions = intent.getStringArrayExtra("askedquestions")
        val results = intent.getBooleanArrayExtra("results")
        
        
        val resultText = StringBuilder()
        if (askedquestions != null && results != null && askedquestions.size == results.size){
            for ( q in askedquestions.indices) {
                resultText.append("${q + 1}. ${askedquestions[q]}\n")
                resultText.append("  Results: ${if (results[q]) "true" else "false"}\n\n")
                
            }
           resultTextView.text = resultText.toString()
            
        } else{
            resultTextView.text ="Data could not be transferred."
            
        }
        rePlayBtn.setOnClickListener { 
            startActivity(Intent(this, quiz_question::class.java))
        }

       extBtn.setOnClickListener { 
           finish()
           exitProcess(0)
       } 
    }
}