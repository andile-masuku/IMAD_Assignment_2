package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button=findViewById(R.id.startBtn)  // link button with id
        button.setOnClickListener() {
            val intent =
                Intent(this, quiz_question::class.java) //  use intent to link to next screen
            startActivity(intent)
        }

        val exitBtn = findViewById<Button>(R.id.exitBtn)

        // function for the exit button
            exitBtn.setOnClickListener {
                moveTaskToBack(true)
                android.os.Process.killProcess(android.os.Process.myPid())
                exitProcess(1)
            }
        }
    }

