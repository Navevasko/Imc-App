package com.example.imcapp.utils

import android.util.Log
import kotlin.math.round
import kotlin.math.roundToInt

fun calcularIMCD(peso:Float, atividade:String, sexo:String, idade:Int):Int {
    var imcd = 0.0

        if(sexo == "M") {
            if(idade in 18..30) {
                imcd = 15.3 * peso + 679
            }
            else if (idade in 31..59){
                imcd = 11.6 * peso + 879
                return imcd.roundToInt()
            }
            else if(idade >= 60) {
                imcd = 13.5 * peso + 487
                return imcd.roundToInt()
            }
            if(atividade == "Atividade Leve") {
                imcd *= 1.5
            }
            else if(atividade == "Atividade Moderada") {
                imcd *= 1.8
            }
            else if(atividade == "Atividade Intensa") {
                imcd *= 2.1
            }
        }
        else if(sexo == "F"){
            if(idade in 18..30) {
                imcd = 14.7 * peso + 496
                return imcd.roundToInt()
            }
            else if (idade in 31..59){
                imcd = 8.7 * peso + 829
                return imcd.roundToInt()
            }
            else if(idade >= 60) {
                imcd = 10.5 * peso + 596
                return imcd.roundToInt()
            }
            if(atividade == "Atividade Leve") {
                imcd *= 1.6
            }
            else if(atividade == "Atividade Moderada") {
                imcd *= 1.6
            }
            else if(atividade == "Atividade Intensa") {
                imcd *= 1.8
            }
        }

    return imcd.roundToInt()
}