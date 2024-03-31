package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth


class Dashboard : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var textViewEmail: TextView
    private lateinit var textViewForFirstLetter: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        auth = FirebaseAuth.getInstance()
        textViewEmail = findViewById(R.id.textView2)
        textViewForFirstLetter = findViewById(R.id.textView4)

        val gamezonelogin = findViewById<Button>(R.id.button4)
        gamezonelogin.setOnClickListener {

            val intent = Intent(applicationContext, Wallpaper::class.java)
            startActivity(intent)
        }

        val currentUser = auth.currentUser

        if (currentUser != null) {
            // User is already signed in, retrieve email and update TextView
            val userEmail = currentUser.email
            val firstLetter = userEmail?.get(0)?.toUpperCase() ?: ""
            textViewForFirstLetter.text = "$firstLetter"


            textViewEmail.text = " $userEmail"
            Log.d("DashboardActivity", "User Email: $userEmail")
        } else {
            // User is not signed in, you can handle this case as needed
            Log.d("DashboardActivity", "No user signed in")
        }


    }
}