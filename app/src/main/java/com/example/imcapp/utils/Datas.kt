package com.example.imcapp.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period

fun calcularIdade(dataNascimento: String): Int {

    // Obter a data atual
    val hoje = LocalDate.now()

    // 21/05/1999 - 1999/05/21
//    val ano = dataNascimento.subSequence(0, 4).toString().toInt()
//    val mes = dataNascimento.subSequence(5,7).toString().toInt()
//    val dia = dataNascimento.subSequence(8,10).toString().toInt()


    // .split = Separa uma string com um delimitador, EX: 2000-05-20
    // Se o delimitador for "-", ele irá separar assim: 2000   05    20
    val data = dataNascimento.split("/")

    //Converter a data de nascimento que é string em localDate

    val nascimento = LocalDate.of(data.get(2).toInt(), data.get(1).toInt(), data.get(0).toInt())

    //Calcular o intervalo entre a data atual(hoje) e a data de nascimento
    // Period.between = calcula o período de tempo entre datas
    val idade = Period.between(nascimento, hoje).years

    Log.i("xpto", idade.toString())

    return idade
}