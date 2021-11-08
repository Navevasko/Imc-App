package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import java.util.*

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

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editNome = findViewById(R.id.edit_nome)
        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editDataNascimento = findViewById(R.id.edit_data_nascimento)
        rdoMasc = findViewById(R.id.rdo_masc)
        rdoFem = findViewById(R.id.rdo_fem)

        //Criar um calendário

        // *** Obter a data atual (hoje)

        // Colocar um Listener de click no editText Data de Nascimento para abrir o calendário (DatePicker)

        editDataNascimento.setOnClickListener {
            CriarDatePicker()
        }

    }

    private fun CriarDatePicker() {

        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->

            var mesReal = _mes + 1

            var diaString = "$_dia"
            var mesString = "$mesReal"

            if (mesReal < 10) {
                mesString = "0$mesReal"
            }
            if (_dia < 10) {
                diaString = "0$_dia"
            }

            editDataNascimento.setText("$diaString/$mesString/$_ano")
        }, ano, mes, dia)

        datePicker.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(validarCampos()) {
            // Gravar os dados no SharedPreferences

                //Criação de uma variável para indicar onde fica o arquivo. o "getSharedPreferences" é usado para criar ou abrir um diretório aonde todas as informações serão armazenadas
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

            // Criação da variável para inserir, apagar ou atualizar os dados
            val editor = arquivo.edit()

            // editor = variável de edição criada acima. ".put'Tipodedado'" = usado para inserir um dado dentro do diretório
            editor.putString("email", editEmail.text.toString())
            editor.putString("senha", editSenha.text.toString())
            editor.putString("nome", editNome.text.toString())
            editor.putString("profissao", editProfissao.text.toString())
            editor.putString("Nascimento", editDataNascimento.text.toString())
            editor.putFloat("altura", editAltura.text.toString().toFloat())
            editor.putString("sexo", if(rdoMasc.isChecked) "M" else "F")

            //Aplica tudo
            editor.apply()

            Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

            // Fecha essa tela da aplicação
            finish()

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

        if(editNome.text.isEmpty()) {
            editNome.error = "O Nome é obrigatório"
            valido = false
        }

        //Aqui, o "!" é usado para fazer a operação contrária. Exemplo: !rdoFem.isChecked() = "O rdoFem !NÃO! está marcado?"
        if(!rdoFem.isChecked() && !rdoMasc.isChecked) {
            editAltura.error = "Escolha um Gênero"
            valido = false
        }

        if(editAltura.text.isEmpty()) {
            editAltura.error = "A Altura é obrigatória"
            valido = false
        }

        if(editDataNascimento.text.isEmpty()) {
            editDataNascimento.error = "A Data de Nascimento é obrigatória"
            valido = false
        }

        return valido

    }
    //SQLite é um banco de dados instalado em todos os dispositivos que não são pcs ou notebooks. Ele utiliza todos os comandos SQL
    //Além disso, existe o SharedPreferences, que é usado pra armazenar poucas informações. É em formato de XML
}