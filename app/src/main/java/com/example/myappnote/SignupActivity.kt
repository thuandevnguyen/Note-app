package com.example.myappnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
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
import androidx.core.content.ContextCompat

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //Hiện màu chữ Signup và click
        val signInTextView = findViewById<TextView>(R.id.textSignin)
        val spannableString = SpannableString("Don’t have an account? Sign in")

        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                startActivity(intent)
            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(this@SignupActivity, R.color.blue) // Set the text color to blue
                ds.isUnderlineText = false // Remove the underline
            }
        }
        spannableString.setSpan(clickableSpan, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        signInTextView.text = spannableString
        signInTextView.movementMethod = LinkMovementMethod.getInstance()



        val btn_signupp = findViewById<Button>(R.id.btn_signup)
        btn_signupp.setOnClickListener {
            val username = findViewById<EditText>(R.id.editTextUsername).text.toString()
            val password = findViewById<EditText>(R.id.editTextPassword).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.editTextConfirmPassword).text.toString()

            // Xác thực dữ liệu
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                // Hiển thị thông báo lỗi nếu có trường rỗng
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                // Hiển thị thông báo lỗi nếu mật khẩu và mật khẩu xác nhận không khớp
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // Tạo tài khoản thành công, thực hiện các thao tác cần thiết
                // ví dụ: lưu thông tin tài khoản vào cơ sở dữ liệu
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }


}