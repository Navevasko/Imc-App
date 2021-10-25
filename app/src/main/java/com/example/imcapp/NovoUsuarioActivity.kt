package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText
    lateinit var rdoMasc: RadioButton
    lateinit var rdoFem: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {

        editNome = findViewById(R.id.edit_nome)
        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editDataNascimento = findViewById(R.id.edit_data_nascimento)
        rdoMasc = findViewById(R.id.rdo_masc)
        rdoFem = findViewById(R.id.rdo_fem)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(validarCampos()) {
            // Gravar os dados
        }
        else {
            // Não gravar nada
        }

        return true
    }

    private fun validarCampos() : Boolean{

        var valido = true

        if(editEmail.text.isEmpty()) {
            editEmail.error = "O Email é obrigatório"
            valido = false
        }

        if(editSenha.text.isEmpty()) {
            editSenha.error = "A senha é obrigatória"
            valido = false
        }

        return valido

    }
}