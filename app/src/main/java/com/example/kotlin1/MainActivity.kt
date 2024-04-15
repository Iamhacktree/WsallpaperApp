package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gamezonelogin = findViewById<Button>(R.id.button2)
        gamezonelogin.setOnClickListener {
            val intent = Intent(applicationContext, CategoryActivity::class.java)
            startActivity(intent)

        }

    }

}

