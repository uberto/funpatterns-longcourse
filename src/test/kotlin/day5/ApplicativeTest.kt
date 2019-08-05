package day5


import day4.Console


fun qaConsole(showQuestion: Console<Unit>, readAnswer: Console<String>): Console<String> = TODO()

fun question(msg: String): Console<String> = TODO()

data class Person(val name: String, val surname: String, val country: String)


fun main() {


    val conPerson = question("your name") applyOn
            question("your surname") applyOn
            question("your country") map3 ::Person


    val p = conPerson.exec()

    println(p)
}

infix fun <A, B> Console<A>.applyOn(other: Console<B>): Console<Pair<A, B>> {
    TODO()
}


infix fun <A, B, R> Console<Pair<A, B>>.map2(f: (A, B) -> R): Console<R> {
    TODO()
}

infix fun <A, B, C, R> Console<Pair<Pair<A, B>, C>>.map3(f: (A, B, C) -> R): Console<R> {
    TODO()
}
