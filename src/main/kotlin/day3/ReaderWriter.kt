package day3


interface Writer<T> {
    fun runWriter(f: () -> T?)
}


interface Reader<T, U> {
    fun ask(what: T): U
}

