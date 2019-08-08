package day3

import day1.andThen


data class FunReader<C, A>(val runner: (C) -> A) : Reader<C, A> {

    override fun runReader(context: C): A = runner(context)

    override fun local(f: (C) -> C): Reader<C, A> = FunReader(f andThen runner)

}