package day2

import java.util.*

object RPNCalc {

    val stack = ArrayDeque<Double>()

    fun calc(cmd: String): Double {
        val elements = cmd.split(" ")

        return elements.fold(0.0, RPNCalc::rpn)
    }

    private fun rpn(acc: Double, elem: String): Double = TODO()

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