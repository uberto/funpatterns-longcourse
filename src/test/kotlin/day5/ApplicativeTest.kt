package day5


import day4.Console
import day4.question


data class Person(val name: String, val surname: String, val country: String)


fun main() {


    val conPerson = question("your name") applyOn
            question("your surname") applyOn
            question("your country") map3 ::Person


    val p = conPerson.exec()

    println(p)
}

infix fun <A, B> Console<A>.applyOn(other: Console<B>): Console<Pair<A, B>> {
    return Console({ Pair(this.exec(), other.exec()) })
}


infix fun <A, B, R> Console<Pair<A, B>>.map2(f: (A, B) -> R): Console<R> {
    val (a, b) = this.exec()

    return Console({ f(a, b) })
}

infix fun <A, B, C, R> Console<Pair<Pair<A, B>, C>>.map3(f: (A, B, C) -> R): Console<R> {
    val (pair, c) = this.exec()
    val (a, b) = pair
    return Console({ f(a, b, c) })
}
