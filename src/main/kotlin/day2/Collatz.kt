package day2


fun Int.collatz(): List<Int> = TODO()

private fun evenCase(n: Int) = (n / 2).collatz()
private fun oddCase(n: Int) = if (n == 1) listOf() else (n * 3 + 1).collatz()




var x = 1
fun collatzMax(): Sequence<Int> = TODO() //return the max value in the collatz seq for the number