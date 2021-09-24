package br.com.programadordeelite.gdc.codelab.debugging.calc

open class Calculator {
    enum class Operator { ADD, SUB, DIV, MUL }

    open fun add(firstOperand: Double, secondOperand: Double): Double = firstOperand + secondOperand

    open fun sub(firstOperand: Double, secondOperand: Double): Double = firstOperand - secondOperand

    open fun div(firstOperand: Double, secondOperand: Double): Double = firstOperand / secondOperand

    open fun mul(firstOperand: Double, secondOperand: Double): Double = firstOperand * secondOperand
}