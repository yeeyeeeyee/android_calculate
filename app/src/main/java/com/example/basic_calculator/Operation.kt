package com.example.basic_calculator

import java.math.BigDecimal
import java.math.RoundingMode

class Operation {
    private fun plus(num1: Number, num2: Number): BigDecimal {
        return when {
            num1 is Int && num2 is Int -> BigDecimal(num1.toInt()) + BigDecimal(num2.toInt())
            else -> BigDecimal.valueOf(num1.toDouble()) + BigDecimal.valueOf(num2.toDouble())
        }
    }

    private fun minus(num1: Number, num2: Number): BigDecimal {
        return when {
            num1 is Int && num2 is Int -> BigDecimal(num1.toInt()) - BigDecimal(num2.toInt())
            else -> BigDecimal.valueOf(num1.toDouble()) - BigDecimal.valueOf(num2.toDouble())
        }
    }

    private fun multiplied(num1: Number, num2: Number): BigDecimal {
        return when {
            num1 is Int && num2 is Int -> BigDecimal(num1.toInt()) * BigDecimal(num2.toInt())
            else -> BigDecimal.valueOf(num1.toDouble()) * BigDecimal.valueOf(num2.toDouble())
        }
    }

    private fun divided(num1: Number, num2: Number): BigDecimal {
        if (num2.toDouble() == 0.0) {
            return BigDecimal.valueOf(-1)
        }
        return BigDecimal(num1.toDouble()).divide(
            BigDecimal(num2.toDouble()),
            10,
            RoundingMode.HALF_UP
        )
    }


    fun operation(num1: Number, num2: Number, operation: String): String {
        val result = when (operation) {
            "+" -> plus(num1, num2)
            "-" -> minus(num1, num2)
            "x" -> multiplied(num1, num2)
            "÷" -> divided(num1, num2)
            else -> BigDecimal.ZERO
        }

        return if (result.scale() > 0 ) result.toDouble().toString() else result.toInt().toString()
    }
}

