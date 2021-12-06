package com.example.imcapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import com.example.imcapp.R
import com.example.imcapp.utils.transformarData
import java.time.LocalDate

class PesagemActivity2 : AppCompatActivity() {

    lateinit var tvDataPesagem : TextView
    lateinit var editNovoPeso : EditText
    lateinit var buttonRegistrarPeso : Button
    lateinit var spinnerAtividades : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem2)
        supportActionBar!! .hide()

        tvDataPesagem = findViewById(R.id.tv_data_pesagem2)
        buttonRegistrarPeso = findViewById(R.id.button_registrar_peso)
        editNovoPeso = findViewById(R.id.edit_new_peso)
        spinnerAtividades = findViewById(R.id.spinner_atividades)

        tvDataPesagem.text = transformarData(LocalDate.now().toString())

        buttonRegistrarPeso.setOnClickListener {
            gravarPeso()
        }
    }

    private fun gravarPeso() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val editor = arquivo.edit()

        editor.putString("data-pesagem", LocalDate.now().toString())
        editor.putString("peso", editNovoPeso.text.toString())
        editor.putInt("nivel_atividade", spinnerAtividades.selectedItemPosition)
        editor.remove("pesos")
        editor.remove("data-pesos")

        editor.commit()
    }
}