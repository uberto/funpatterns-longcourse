package day2

data class Monoid<T: Any>(val zero: T, val combine: (T, T) -> T) {

    fun Iterable<T>.fold(): T = TODO()
}