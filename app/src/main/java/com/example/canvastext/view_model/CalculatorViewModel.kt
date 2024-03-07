package com.example.canvastext.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CalculatorViewModel:ViewModel() {
    private val _operationsText = mutableStateOf<String>("")
    val operation: State<String>
        get() = _operationsText

    private val _resultText = mutableStateOf<String>("")
    val result: State<String>
        get() = _resultText

    private fun safeOperation() =
        _operationsText.value.isNotEmpty() && _operationsText.value.last() !in listOf(
            'x', '÷', '+', '-', '.'
        )


    fun delete() {
        if (_operationsText.value.isNotEmpty()) {
            _operationsText.value = ""
            _resultText.value = ""
        }
    }

    fun deleteLast() {
        if (_operationsText.value.isNotEmpty()) {
            _operationsText.value = _operationsText.value.dropLast(1)

        }
    }

    fun mod(){
        if(safeOperation()) {
            _operationsText.value += "%"
        }
    }

    fun add() {
        if (safeOperation()) {
            _operationsText.value += "+"

        }
    }

    fun dot() {
        if (safeOperation()) {
            _operationsText.value += "."
        }
    }

    fun minus() {
        if (safeOperation()) {
            _operationsText.value += "-"
        }
    }

    fun multi() {
        if (safeOperation()) {
            _operationsText.value += "x"

        }
    }

    fun divide() {
        if (safeOperation()) {
            _operationsText.value += "÷"

        }
    }

    fun result() {
        viewModelScope.launch {
            if (safeOperation()) {
                _resultText.value = calculate(_operationsText.value).toString()
            } else {
                deleteLast()
                _resultText.value = calculate(_operationsText.value).toString()
            }
        }
    }


    fun zero() {
        _operationsText.value += "0"

    }

    fun one() {
        _operationsText.value += "1"
    }

    fun two() {
        _operationsText.value += "2"
    }

    fun three() {
        _operationsText.value += "3"
    }

    fun four() {
        _operationsText.value += "4"
    }

    fun five() {
        _operationsText.value += "5"
    }

    fun six() {
        _operationsText.value += "6"
    }

    fun seven() {
        _operationsText.value += "7"
    }

    fun eight() {
        _operationsText.value += "8"
    }

    fun nine() {
        _operationsText.value += "9"
    }

    private fun calculate(input: String): Double {
        val tokens = tokenize(input)
        val precedence = mapOf("+" to 1, "-" to 1, "x" to 2, "÷" to 2, "%" to 2) // Operator precedence map
        val outputStack = mutableListOf<Double>()
        val operatorStack = mutableListOf<String>()

        for (token in tokens) {
            when {
                token.toDoubleOrNull() != null -> outputStack.add(token.toDouble()) // If token is number, add to output stack
                token in precedence -> { // If token is operator
                    val p1 = precedence[token] // Get precedence of current operator
                    while (operatorStack.isNotEmpty() && operatorStack.last() in precedence) {
                        // While there are operators on the operator stack with higher or equal precedence
                        val p2 = precedence[operatorStack.last()]!!
                        if (p2 >= p1 ?: 0) {
                            val op = operatorStack.removeLast()
                            val b = outputStack.removeLast()
                            val a = outputStack.removeLast()
                            outputStack.add(applyOperator(a, b, op))
                        } else {
                            break
                        }
                    }
                    operatorStack.add(token) // Add current operator to operator stack
                }
                else -> throw IllegalArgumentException("Invalid token: $token")
            }
        }

        // While there are still operators on the operator stack
        while (operatorStack.isNotEmpty()) {
            val op = operatorStack.removeLast()
            val b = outputStack.removeLast()
            val a = outputStack.removeLast()
            outputStack.add(applyOperator(a, b, op))
        }

        return outputStack.single() // Return final result
    }

    fun applyOperator(a: Double, b: Double, op: String): Double {
        return when (op) {
            "+" -> a + b
            "-" -> a - b
            "x" -> a * b
            "÷" -> a / b
            "%" -> a % b
            else -> throw IllegalArgumentException("Invalid operator: $op")
        }
    }

    fun tokenize(input: String): List<String> {
        val tokens = mutableListOf<String>()
        var currentToken = ""
        for (c in input) {
            if (c.isDigit() || c == '.') {
                currentToken += c
            } else {
                if (currentToken.isNotEmpty()) {
                    tokens.add(currentToken)
                }
                tokens.add(c.toString())
                currentToken = ""
            }
        }
        if (currentToken.isNotEmpty()) {
            tokens.add(currentToken)
        }
        return tokens
    }
}
