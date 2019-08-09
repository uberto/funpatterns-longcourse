package day4

data class Calculator(
    val writer: (String) -> Console<Unit>,
    val reader: () -> Console<String>
) {

    operator fun invoke() {
       TODO()
    }

}

fun main() {
    val calc = Calculator(::printIO, ::readlineIO)

    while (true) {
        calc()
    }
}

