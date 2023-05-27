package com.example.myappnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)


        // Tạm dừng trong 5 giây trước khi chuyển sang màn hình đăng nhập
        Handler().postDelayed({
            val intent = Intent(this@LoadingActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // 5000 là thời gian tạm dừng tính bằng mili giây (5 giây)
    }

}