package day2


fun Int.collatz() = collatzR(listOf(), this)

tailrec fun collatzR(acc: List<Int>, x: Int): List<Int> = TODO()


var hiddenX = 1
fun collatzMax(): Sequence<Int> = generateSequence {
    TODO()
}