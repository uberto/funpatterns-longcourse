package day2


fun Int.collatz() = collatzR(listOf(), this)

tailrec fun collatzR(acc: List<Int>, x: Int): List<Int> = when {
    x == 1 -> TODO()
    x % 2 == 0 -> TODO()
    else -> TODO()
}


var hiddenX = 1
fun collatzMax(): Sequence<Int> = generateSequence {
    TODO()
}