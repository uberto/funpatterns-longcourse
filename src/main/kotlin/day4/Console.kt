package day4

import java.io.BufferedReader
import java.io.InputStreamReader


data class Console<A> (val exec: () -> A) {

    fun <R> andThen(other: Console<R>): Console<R> = Console {
        this.exec()
        other.exec()
    }

    fun <B> map(f: (A) -> B): Console<B> = Console {
        f(exec())
    }

    fun <B> flatMap(f: (A) -> Console<B>): Console<B> = Console {
        f(exec()).exec()
    }

}


fun printIO(msg: String): Console<Unit> = Console { println(msg) }

val reader =  BufferedReader( InputStreamReader(System.`in`))

fun readlineIO() = Console<String> { reader.readLine() }


fun qaConsole(showQuestion: Console<Unit>, readAnswer: Console<String>): Console<String> = TODO()

fun question(msg: String): Console<String> = qaConsole(printIO(msg), readlineIO())
