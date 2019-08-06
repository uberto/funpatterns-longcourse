package day3


data class FunReader<C, A>(val runner: (C) -> A): Reader<C, A> {

    override fun runReader(context: C): A = TODO()

    override fun local(f: (C) -> C): Reader<C, A> = TODO()

}