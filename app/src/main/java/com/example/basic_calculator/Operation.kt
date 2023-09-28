package com.example.basic_calculator

import android.annotation.SuppressLint
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.sqrt

class Operation {
    private fun performOperation(num1: Double, num2: Double, operation: String): BigDecimal {
        return when (operation) {
            "+" -> BigDecimal.valueOf(num1).add(BigDecimal.valueOf(num2))
            "-" -> BigDecimal.valueOf(num1).minus(BigDecimal.valueOf(num2))
            "x" -> BigDecimal.valueOf(num1).multiply(BigDecimal.valueOf(num2))
            "÷" -> BigDecimal(num1).divide(
                BigDecimal(num2),
                5,
                RoundingMode.HALF_UP
            )
            //取餘數
            "%" -> BigDecimal.valueOf(num1).remainder(BigDecimal.valueOf(num2))
            else -> BigDecimal.ZERO
        }
    }
    //雙參數
    fun operation(num1: Double, num2: Double, operation: String): String {
        val result = performOperation(num1, num2, operation)
        return result.stripTrailingZeros().toPlainString()
    }

    //單參數

    private fun performOperation(num1: Double, operation: String): BigDecimal {
        return when (operation) {
            "%" -> BigDecimal.valueOf(num1).divide(BigDecimal.valueOf(100))
            "x²" -> BigDecimal.valueOf(num1).pow(2)
            "⅟x"-> BigDecimal.valueOf(1).divide(BigDecimal.valueOf(num1))
            "√x" -> {
                val sqrtResult = BigDecimal.valueOf(sqrt(num1))
                return sqrtResult.setScale(5, RoundingMode.HALF_UP)
            }

            else -> BigDecimal.ZERO
        }
    }
    @SuppressLint("SuspiciousIndentation")
    fun operation(num1: Double, operation: String): String {
        val result =  performOperation(num1, operation)
            return result.stripTrailingZeros().toPlainString()
        }


}



