package com.example.projecteventbab4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class jajargenjang : AppCompatActivity() {
    private lateinit var alas: EditText
    private lateinit var tinggi: EditText
    private lateinit var tvHasil: TextView

    private lateinit var sharedPreference: SharedPreferences
    private val PREF_NAME = "Shared"
    private val KEY_NAME = "ResultCalc"
    private val KEY_ET_ONE = "EtOne"
    private val KEY_ET_TWO = "EtTwo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jajargenjang)
        alas = findViewById(R.id.et_alasJajarGenjang)
        tinggi = findViewById(R.id.et_tinggiJajarGenjang)
        tvHasil = findViewById(R.id.hasilbeneran)
        sharedPreference = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val result = sharedPreference.getFloat(KEY_NAME,0.0f)
        val etNumberOneRestore = sharedPreference.getString(KEY_ET_ONE, "0")
        val etNumberTwoRestore = sharedPreference.getString(KEY_ET_TWO, "0")
        alas.setText(etNumberOneRestore)
        tinggi.setText(etNumberTwoRestore)
        tvHasil.setText(etNumberTwoRestore)
        findViewById<Button>(R.id.btn_hitungLuasJajarGenjang).setOnClickListener {
            val hasil: Float
            hasil = alas.text.toString().toFloat() * tinggi.text.toString().toFloat()
            tvHasil.text = hasil.toString()
        }

        findViewById<Button>(R.id.btn_backHome).setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putFloat(KEY_NAME, tvHasil.text.toString().toFloat())
        editor.putString(KEY_ET_ONE,alas.text.toString())
        editor.putString(KEY_ET_TWO,tinggi.text.toString())
        editor.apply()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val result = sharedPreference.getFloat(KEY_NAME, 0.0f)
        tvHasil.text = result.toString()
    }
}