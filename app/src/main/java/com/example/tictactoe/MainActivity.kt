package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindings:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        bindings.btnSinglePlayer.setOnClickListener{
            val intent = Intent(this, SinglePlayer::class.java)
            startActivity(intent)
        }
        setContentView(bindings.root)
    }

    companion object{
        val linuxImage = R.mipmap.linux_penguim
        val androidImage = R.mipmap.android_icon
    }
}