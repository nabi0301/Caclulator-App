package com.example.calculator

enum class Operations {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

class Calculator(private val operand1: Double, private val operand2: Double) {

    fun calculate(operation: Operations): Double {
        return when (operation) {
            Operations.ADD -> operand1 + operand2
            Operations.SUBTRACT -> operand1 - operand2
            Operations.MULTIPLY -> operand1 * operand2
            Operations.DIVIDE -> {
                if (operand2 != 0.0) {
                    operand1 / operand2
                } else {
                    Double.NaN // Handle division by zero
                }
            }
        }
    }
}
