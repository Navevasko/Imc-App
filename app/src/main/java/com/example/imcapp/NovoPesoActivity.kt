package com.example.imcapp

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.imcapp.utils.transformarData
import java.time.LocalDate

class NovoPesoActivity : AppCompatActivity(){

    lateinit var spinner : Spinner
    lateinit var novoPeso : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_peso)
        supportActionBar!! .hide()

        val hoje = LocalDate.now().toString()

        novoPeso = findViewById(R.id.edit_novo_peso)
        spinner = findViewById(R.id.spinner_atividade)
        val atividade = spinner.selectedItem
        val dataAtual : TextView = findViewById(R.id.tv_data_pesagem)
        dataAtual.text = transformarData(hoje)

        var buttonRegistrar : Button = findViewById(R.id.button_registrar)


        buttonRegistrar.setOnClickListener {
            Log.i("xpto", novoPeso.text.toString())
            Log.i("xpto", atividade.toString())

            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val edit = arquivo.edit()

            edit.putFloat("pesos", novoPeso.text.toString().toFloat())
            edit.putString("data-pesos", dataAtual.text.toString())
            edit.putString("atividade", atividade.toString())

            edit.apply()

        }

    }
}