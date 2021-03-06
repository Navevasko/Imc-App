package com.example.imcapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.imcapp.R
import com.example.imcapp.utils.calcularIdade

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        val buttonCadastro = findViewById<Button>(R.id.button_cadastro)
        val editEmail = findViewById<EditText>(R.id.edit_login_email)
        val editSenha = findViewById<EditText>(R.id.edit_login_senha)

        buttonCadastro.setOnClickListener {
            val abrirCadastro = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirCadastro)
        }

        buttonEntrar.setOnClickListener {

            calcularIdade("15/07/2004")
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val email = arquivo.getString("email", "")
            val senha = arquivo.getString("senha", "")

            if(email == editEmail.text.toString() && senha == editSenha.text.toString()) {
                val abrirDashBoard = Intent(this, DashBoardActivity::class.java)
                startActivity(abrirDashBoard)
            }
            else {
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}