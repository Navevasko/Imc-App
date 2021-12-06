package com.example.imcapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.imcapp.R
import com.example.imcapp.utils.transformarData
import java.time.LocalDate

class NovoPesoActivity : AppCompatActivity(){

    lateinit var spinnerAtividades : Spinner
    lateinit var editNovoPeso : EditText
    lateinit var buttonRegistrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_peso)
        supportActionBar!! .hide()

       editNovoPeso = findViewById(R.id.edit_novo_peso)
       spinnerAtividades = findViewById(R.id.edit_novo_peso)
       buttonRegistrar = findViewById(R.id.button_registrar)


        buttonRegistrar.setOnClickListener {
            gravarPeso()
        }

    }

    private fun gravarPeso() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val editor = arquivo.edit()

        val peso = arquivo.getString("peso", "")
        val dataPesagem = arquivo.getString("data-pesagem", "")

        editor.putString("data-pesagem", "$dataPesagem;${LocalDate.now()}")
        editor.putString("peso", "$peso; ${editNovoPeso.text}")
        editor.putInt("nivel_atividade", spinnerAtividades.selectedItemPosition)
        editor.remove("pesos")
        editor.remove("data-pesos")

        editor.commit()
    }
}