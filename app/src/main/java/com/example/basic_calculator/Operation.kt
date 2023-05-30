package com.example.basic_calculator

import java.math.BigDecimal
import java.math.RoundingMode

class Operation {
    private fun plus(num1: Double, num2: Double): BigDecimal {
        return  BigDecimal.valueOf(num1) + BigDecimal.valueOf(num2)
        }


    private fun minus(num1: Double, num2: Double): BigDecimal {
        return  BigDecimal.valueOf(num1) - BigDecimal.valueOf(num2)

    }

    private fun multiplied(num1: Double, num2: Double): BigDecimal {
        return  BigDecimal.valueOf(num1) * BigDecimal.valueOf(num2)
        }


    private fun divided(num1: Double, num2: Double): BigDecimal {
        if (num2 == 0.0) {
            return BigDecimal.valueOf(-1)
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

        return if (result.toString().last()=='0') {
            result.toString().dropLast(2)
        } else {
            result.toString()
        }
    }
}

