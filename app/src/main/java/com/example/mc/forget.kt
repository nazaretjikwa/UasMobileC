package com.example.mc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mc.databinding.ActivityForgetBinding
import com.example.mc.databinding.ActivityRegisterBinding

class forget : AppCompatActivity() {
    private lateinit var binding: ActivityForgetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forget)

        binding = ActivityForgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.for2.setOnClickListener{
            val intentfor = Intent( this, MainActivity::class.java)
            startActivity(intentfor)
        }
        }
    }
