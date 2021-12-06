package com.example.imcapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.imcapp.R
import com.example.imcapp.utils.calcularIMC
import com.example.imcapp.utils.calcularIMCD
import com.example.imcapp.utils.calcularIdade

class DashBoardActivity : AppCompatActivity() {

    lateinit var text_nome : TextView
    lateinit var text_profissao : TextView
    lateinit var text_idade : TextView
    lateinit var text_altura : TextView
    lateinit var text_imcd : TextView
    lateinit var pesar_agora : RelativeLayout
    lateinit var text_peso : TextView
    lateinit var text_imc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!! .hide()

        text_nome = findViewById(R.id.text_nome)
        text_profissao = findViewById(R.id.text_profissao)
        text_idade = findViewById(R.id.text_idade)
        text_imcd = findViewById(R.id.text_imcd)
        text_altura = findViewById(R.id.text_altura)
        pesar_agora = findViewById(R.id.pesar_agora)
        text_peso = findViewById(R.id.tv_peso)
        text_imc = findViewById(R.id.tv_imc)

        pesar_agora.setOnClickListener {
            val abrirPesagem = Intent(this, NovoPesoActivity::class.java)
            startActivity(abrirPesagem)
        }

        preencherDashboard()

    }

    private fun preencherDashboard () {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val nascimento = arquivo.getString("Nascimento", "").toString()
        val altura = arquivo.getFloat("altura", 0F)
        val peso = arquivo.getFloat("pesos", 0F)
        val atividade = arquivo.getString("atividade", "").toString()
        val sexo = arquivo.getString("sexo", "").toString()
        val idade = calcularIdade(nascimento).toString().toInt()
        val imc = calcularIMC(peso, altura)
        val imcd = calcularIMCD(peso, atividade, sexo, idade)

        Log.i("xpto", peso.toString())
        Log.i("xpto", atividade)
        Log.i("xpto", sexo)
        Log.i("xpto", idade.toString())
        Log.i("xpto", imcd.toString())

        text_nome.text = arquivo.getString("nome", "")
        text_profissao.text = arquivo.getString("profissao", "")
        text_idade.text = idade.toString()
        text_altura.text = arquivo.getFloat("altura", 0.0f).toString()
        text_imcd.text = imcd.toString()
        text_peso.text = peso.toString()
        text_imc.text = imc.toString()
    }
}