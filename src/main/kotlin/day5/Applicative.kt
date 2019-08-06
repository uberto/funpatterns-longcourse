package day5

data class Applicative<T>(val value: T) {

    fun <U> combine(other: Applicative<U>): Applicative<Pair<T, U>> = TODO()

    fun <R> applyOn(other: Applicative<(T) -> R>): Applicative<R> = TODO()
}

fun <A, B, R> Applicative<Pair<A, B>>.map2(f: (A, B) -> R): Applicative<R> = TODO()


fun <A, B, C, R> Applicative<Triple<A, B, C>>.map3(f: (A, B, C) -> R): Applicative<R> = TODO()

