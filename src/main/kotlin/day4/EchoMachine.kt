package day4

data class EchoMachine(
    val writer: (String) -> Console<Unit>,
    val reader: () -> Console<String>
) {

    operator fun invoke() {
        TODO()
    }
}
