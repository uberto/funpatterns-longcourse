package day2


fun Int.collatz(): List<Int> = listOf(this) + if (this % 2 == 0) evenCase(this) else oddCase(this)

private fun evenCase(n: Int) = (n / 2).collatz()
private fun oddCase(n: Int) = if (n == 1) listOf() else (n * 3 + 1).collatz()