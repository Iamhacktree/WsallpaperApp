package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Gamezone : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamezone)

        val gotoLoginPage = findViewById<Button>(R.id.button3)
        gotoLoginPage.setOnClickListener{
            val intent = Intent(applicationContext, LoginScreen::class.java)
            startActivity(intent)
        }




        // Initialize Firebase
        FirebaseApp.initializeApp(this)
        auth = FirebaseAuth.getInstance()

        // Check if the user is already authenticated
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // User is already logged in, redirect to Dashboard
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Finish LoginActivity to prevent going back to it
        }

        // Find views
        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextNumberPassword)

        // Perform sign-up when a button is clicked (you can replace it with your button)
        val createAccount = findViewById<Button>(R.id.button)
        createAccount.setOnClickListener {
            signUp()
        }

    }

    private fun signUp() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Validate email and password
        if (!isValidEmail(email)) {
            emailEditText.error = "Invalid email address"
            return
        }

        if (password.length < 6) {
            passwordEditText.error = "Password should be at least 6 characters"
            return
        }


        // Create user with email and password
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign up success, update UI with the signed-in user's information
                    val user: FirebaseUser? = auth.currentUser
                    Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()

                    // Move to Dashboard screen (replace DashboardActivity::class.java with your Dashboard activity)
                    startActivity(Intent(this, StartScreenActivity::class.java))
                    finish()
                } else {
                    // If sign up fails, display a message to the user.
                    Toast.makeText(baseContext, "Sign up failed. Please try again.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }



}