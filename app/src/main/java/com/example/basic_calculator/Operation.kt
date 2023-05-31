package com.example.basic_calculator

import java.math.BigDecimal
import java.math.RoundingMode

class Operation {
    //兩個參數
    private fun plus(num1: Double, num2: Double): BigDecimal {
        return BigDecimal.valueOf(num1).add(BigDecimal.valueOf(num2))
    }


    private fun minus(num1: Double, num2: Double): BigDecimal {
        return BigDecimal.valueOf(num1).minus(BigDecimal.valueOf(num2))

    }

    private fun multiplied(num1: Double, num2: Double): BigDecimal {
        return BigDecimal.valueOf(num1).multiply(BigDecimal.valueOf(num2))
    }


    private fun divided(num1: Double, num2: Double): BigDecimal {
        if (num2 == 0.0) {
            return BigDecimal.valueOf(0)
        }
        return BigDecimal(num1).divide(
            BigDecimal(num2),
            5,
            RoundingMode.HALF_UP
        )
    }


    fun operation(num1: Double, num2: Double, operation: String): String {
        val result = when (operation) {
            "+" -> plus(num1, num2)
            "-" -> minus(num1, num2)
            "x" -> multiplied(num1, num2)
            "÷" -> divided(num1, num2)
            else -> BigDecimal.ZERO
        }

        return return result.stripTrailingZeros().toPlainString()
    }

    //---------------------------------------------------------------------------------------------

    //一個參數
    private fun percent(num1: Double):BigDecimal{
        return BigDecimal.valueOf(num1).divide(BigDecimal.valueOf(100))
    }

    fun operation(num1: Double, operation: String): String {
        val result = when (operation) {
            "%" -> percent(num1)

            else -> BigDecimal.ZERO
        }

        return result.stripTrailingZeros().toPlainString()
    }


}

