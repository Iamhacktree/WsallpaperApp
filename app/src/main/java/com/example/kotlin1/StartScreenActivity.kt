package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class StartScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        val category=findViewById<ImageButton>(R.id.imageButton)
        category.setOnClickListener {
            startActivity(Intent(this,CategoryActivity::class.java))
        }

        val profile=findViewById<ImageButton>(R.id.imageButton2)
        profile.setOnClickListener {
            startActivity(Intent(this,Dashboard::class.java))
        }
    }

}