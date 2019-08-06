package day3


interface Writer<T> {
    fun runWriter(f: () -> T?)
}


interface Reader<C, A> {

    fun C.runReader(f: (A) -> Unit)
    fun ask(context: C): A

}
