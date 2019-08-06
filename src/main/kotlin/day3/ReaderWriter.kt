package day3


interface Writer<T> {
    fun runWriter(f: () -> T?)
}



interface Reader<C, A> {

    fun runReader(context: C): A

    fun local(f: (C) -> C): Reader<C, A>
}
