package com.example.kotlin1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.widget.EditText


class Dashboard : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var textViewEmail: TextView
    private lateinit var textUserName: TextView
    private lateinit var textViewForFirstLetter: TextView
    private lateinit var textViewRegistrationDate: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        auth = FirebaseAuth.getInstance()
        textViewEmail = findViewById(R.id.textView2)
        textUserName = findViewById(R.id.textView)
        textViewForFirstLetter = findViewById(R.id.textView4)

        val verifiedIcon = findViewById<ImageView>(R.id.verifiedIcon)
        verifiedIcon.setImageResource(R.drawable.img_2)


        val logoutButton = findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            signOut()
        }




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


            val userName = userEmail?.substringBefore('@') ?: ""
            textUserName.text = userName
            Log.d("DashboardActivity", "User Email: $userEmail")


//
//
        } else {
            // User is not signed in, you can handle this case as needed
            Log.d("DashboardActivity", "No user signed in")
        }




    }
    private fun signOut() {
        auth.signOut()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}