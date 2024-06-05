package com.example.mc

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mc.databinding.ActivityDeskripsiBinding
import com.example.mc.databinding.ActivityHomeBinding

class Deskripsi : AppCompatActivity() {
    private lateinit var binding : ActivityDeskripsiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deskripsi)
        binding = ActivityDeskripsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intess = intent
        var actor = intess.getStringExtra("ACTOR")
        var director = intess.getStringExtra("DIRECTOR")
        var gender = intess.getStringExtra("GENDRE")
        var synopsis = intess.getStringExtra("SYNOPSCISE")
        var judul = intess.getStringExtra("JUDUL")
        var img = intess.getStringExtra("IMAGE")


        binding.Actor.text = (actor)
        binding.Director.text =director
        binding.Gender.text = gender
        binding.synopsis.text=(synopsis)
        binding.jdlFilm.text =judul
        binding.imgF.loadImage(img)
    }
    }
