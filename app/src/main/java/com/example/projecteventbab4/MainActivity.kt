package com.example.projecteventbab4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var jajargenjang123: CardView
    private val PREF_NAME = "Shared"
    private val KEY_NAME = "ResultCalc"
    private val KEY_ET_ONE = "EtOne"
    private val KEY_ET_TWO = "EtTwo"
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jajargenjang123 = findViewById(R.id.JajarGenjang)
        findViewById<CardView>(R.id.JajarGenjang).setOnClickListener{
            intent = Intent(this,jajargenjang::class.java)
            startActivity(intent)
        }
    }
}