package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.imcapp.utils.calcularIMCD
import com.example.imcapp.utils.calcularIdade
import org.w3c.dom.Text

class DashBoardActivity : AppCompatActivity() {

    lateinit var text_nome : TextView
    lateinit var text_profissao : TextView
    lateinit var text_idade : TextView
    lateinit var text_altura : TextView
    lateinit var text_imcd : TextView
    lateinit var pesar_agora : RelativeLayout

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

        pesar_agora.setOnClickListener {
            val abrirPesagem = Intent(this, NovoPesoActivity::class.java)
            startActivity(abrirPesagem)
        }

        preencherDashboard()

    }

    private fun preencherDashboard () {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val nascimento = arquivo.getString("Nascimento", "").toString()
        val peso = arquivo.getFloat("pesos", 0F)
        val atividade = arquivo.getString("atividade", "").toString()
        val sexo = arquivo.getString("sexo", "").toString()
        val idade = calcularIdade(nascimento).toString().toInt()

        Log.i("xpto", atividade)
        Log.i("xpto", peso.toString())
        Log.i("xpto", sexo)
        Log.i("xpto", idade.toString())

        val imcd = calcularIMCD(peso, atividade, sexo, idade)

        Log.i("xpto", imcd.toString())

        text_nome.text = arquivo.getString("nome", "")
        text_profissao.text = arquivo.getString("profissao", "")
        text_idade.text = idade.toString()
        text_altura.text = arquivo.getFloat("altura", 0.0f).toString()
        text_imcd.text = imcd.toString()
    }
}