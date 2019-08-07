package day2


fun Int.collatz() = collatzR(listOf(), this)

tailrec fun collatzR(acc: List<Int>, x: Int): List<Int> =
    when {
        x == 1 -> acc.plus(x)
        x % 2 == 0 -> collatzR(acc.plus(x), x / 2)
        else -> collatzR(acc.plus(x), x * 3 + 1)
    }


var hiddenX = 1
fun collatzMax(): Sequence<Int> = generateSequence {
    hiddenX.collatz().max().also { hiddenX += 1 }
}