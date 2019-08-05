package day3


interface Writer<T> {
    fun runWriter(f: () -> T?)
}


interface Reader<T> {
    fun <U> runReader(lineReader: (T) -> U): List<U>
}

