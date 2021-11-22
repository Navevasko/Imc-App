package com.example.imcapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NovoPesoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_peso)
        supportActionBar!! .hide()

    }
}