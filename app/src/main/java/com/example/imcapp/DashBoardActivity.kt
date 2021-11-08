package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class DashBoardActivity : AppCompatActivity() {

    lateinit var text_nome : TextView
    lateinit var text_profissao : TextView
    lateinit var text_idade : TextView
    lateinit var text_altura : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!! .hide()

        text_nome = findViewById(R.id.text_nome)
        text_profissao = findViewById(R.id.text_profissao)
        text_idade = findViewById(R.id.text_idade)
        text_altura = findViewById(R.id.text_altura)

        preencherDashboard()

    }

    private fun preencherDashboard () {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        text_nome.text = arquivo.getString("nome", "")
        text_profissao.text = arquivo.getString("profissao", "")
        text_idade.text = arquivo.getString("Nascimento", "")
        text_altura.text = arquivo.getFloat("altura", 0.0f).toString()
    }
}