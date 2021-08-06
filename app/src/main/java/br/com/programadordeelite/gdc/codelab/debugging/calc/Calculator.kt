package br.com.programadordeelite.gdc.codelab.debugging.calc

class Calculator {
    enum class Operator { ADD, SUB, DIV, MUL }

    fun add(firstOperand: Double, secondOperand: Double): Double = firstOperand + secondOperand

    fun sub(firstOperand: Double, secondOperand: Double): Double = firstOperand - secondOperand

    fun div(firstOperand: Double, secondOperand: Double): Double = firstOperand / secondOperand

    fun mul(firstOperand: Double, secondOperand: Double): Double = firstOperand * secondOperand
}