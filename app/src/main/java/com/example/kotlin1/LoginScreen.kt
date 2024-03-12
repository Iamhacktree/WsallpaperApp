package com.example.kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginScreen : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Check if the user is already authenticated
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // User is already logged in, redirect to Dashboard
            startActivity(Intent(this, Dashboard::class.java))
            finish() // Finish LoginActivity to prevent going back to it
        }

        // Find views
        emailEditText = findViewById(R.id.editTextTextEmailAddressl)
        passwordEditText = findViewById(R.id.editTextNumberPasswordl)

        // Perform login when a button is clicked (replace it with your login button)
        val buttonl = findViewById<Button>(R.id.buttonl)
        buttonl.setOnClickListener {
            login()
        }

    }

    private fun login() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Validate email and password
        if (!isValidEmail(email)) {
            emailEditText.error = "Invalid email address"
            return
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Password is required"
            return
        }



        // Sign in with email and password
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                    // Move to Dashboard screen (replace DashboardActivity::class.java with your Dashboard activity)
                    startActivity(Intent(this, Dashboard::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Login failed. Please check your credentials.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
