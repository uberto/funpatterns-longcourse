package day1

import java.util.*

object RPNCalc {

    val stack = ArrayDeque<Double>()

    fun calc(cmd: String): Double {
        val elements = cmd.split(" ")

        return elements.fold(0.0, ::rpn)
    }

    private fun rpn(acc: Double, elem: String): Double = elem
        .toDoubleOrNull()
        ?.let { stack.push(it); acc }
        ?: operation(elem, stack.pop(), stack.pop()).also (stack::push)

    private fun operation(op: String, x: Double, y: Double): Double {
        val res = when (op) {
            "+" -> x + y
            "-" -> x - y
            "*" -> x * y
            "/" -> x / y
            else -> throw Exception( "Unknown operation $op")
        }
        return res
    }


}