package com.example.myappnote

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Hiện màu chữ Signup và click
        val signUpTextView = findViewById<TextView>(R.id.textSignup)
        val spannableString = SpannableString("Don’t have an account? Sign up")

        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                // Perform the action when the "Sign up" text is clicked
                // For example, navigate to another activity or fragment
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(this@LoginActivity, R.color.blue) // Set the text color to blue
                ds.isUnderlineText = false // Remove the underline
            }

        }
        spannableString.setSpan(clickableSpan, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        signUpTextView.text = spannableString
        signUpTextView.movementMethod = LinkMovementMethod.getInstance()

        // Check login

        val btnLogin = findViewById<Button>(R.id.btn_Login)
        btnLogin.setOnClickListener {
            // Perform login logic here
            val username = findViewById<EditText>(R.id.editTextUsername).text.toString()
            val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

            // Validate the username and password
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Check the credentials against a predefined username and password
                val validUsername = "admin"
                val validPassword = "password"

                if (username == validUsername && password == validPassword) {
                    // If the login is successful, navigate to the main screen
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Optional: Finish the current login activity
                } else {
                    // Display an error message for invalid credentials
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Display an error message if the username or password is empty
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}