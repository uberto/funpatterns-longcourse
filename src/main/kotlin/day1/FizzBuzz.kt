package day1

infix fun String?.compose (other: String?): String? = TODO()

fun fizz(x:Int): String? = TODO()

fun buzz(x:Int): String? = TODO()

fun fizzBuzz(x: Int): String = fizz(x) compose buzz(x) ?: x.toString()


