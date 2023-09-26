package com.example.basic_calculator

import java.math.BigDecimal
import java.math.RoundingMode

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
            else -> BigDecimal.ZERO
        }
    }
    //雙參數
    fun operation(num1: Double, num2: Double, operation: String): String {
        val result = performOperation(num1, num2, operation)
        return result.stripTrailingZeros().toPlainString()
    }

    private fun percent(num1: Double):BigDecimal{
        return BigDecimal.valueOf(num1).divide(BigDecimal.valueOf(100))
    }
    //單參數
    fun operation(num1: Double, operation: String): String {
        val result = when (operation) {
            "%" -> percent(num1)
            else -> BigDecimal.ZERO
        }

        return result.stripTrailingZeros().toPlainString()
    }
}


