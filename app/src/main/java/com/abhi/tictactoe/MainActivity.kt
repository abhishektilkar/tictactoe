package com.abhi.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image.translationY = -1000f
        textView.translationY = 1000f
        image.animate().translationY(0f).duration = 2000
        textView.animate().translationY(0f).duration = 2000
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,StartActivity::class.java)
            startActivity(intent)
        },4000)
    }
}