package com.example.kotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin1.Gamezone
import com.example.kotlin1.R
import com.example.kotlin1.StartScreenActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        // Check if user is already logged in
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // User is already logged in, navigate to StartScreenActivity
            val intent = Intent(this,StartScreenActivity::class.java)
            startActivity(intent)
            finish() // Finish current activity to prevent going back to MainActivity using back button
        }


        // Button to navigate to Gamezone activity
        val gamezonelogin = findViewById<Button>(R.id.button2)
        gamezonelogin.setOnClickListener {
            val intent = Intent(applicationContext, Gamezone::class.java)
            startActivity(intent)
        }
    }
}
