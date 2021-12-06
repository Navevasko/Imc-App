package com.example.imcapp.utils

import android.util.Log
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt
fun calcularIMCD(peso:Float, atividade:String, sexo:String, idade:Int):Double {
    var imcd : Double = 1.0

    var sexo = sexo

    if(sexo == "M") {
        imcd * 10
    }

    return imcd * 10
}

fun calcularIMC (peso:Float, altura:Float) : Int {
    var imc = (peso / altura.pow(2)).roundToInt()
    return imc
}