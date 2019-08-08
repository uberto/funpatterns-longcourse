package day3


sealed class Outcome<out E: Error, out T: Any> {

    fun <U: Any> map(f: (T) -> U): Outcome<E, U> = TODO()

    fun <U: Error> mapFailure(f: (E) -> U): Outcome<U, T> = TODO()

    companion object {
        fun <T: Any> tryThis(block: () -> T): Outcome<ThrowableError, T> =TODO()
    }
}

data class Success<T: Any>(val value: T): Outcome<Nothing, T>()
data class Failure<E: Error>(val error: E): Outcome<E, Nothing>()


fun <T: Any, U: Any, E: Error> Outcome<E, T>.lift(f: (T) -> U): (Outcome<E, T>) -> Outcome<E, U> = TODO()

inline fun <T: Any, U: Any, E: Error> Outcome<E, T>.flatMap(f: (T) -> Outcome<E, U>): Outcome<E, U> = TODO()

inline fun <E: Error, T: Any> Outcome<E, T>.mapNullableError(f: (T) -> E?): Outcome<E, Unit> = TODO()

inline fun <T: Any, E: Error> Outcome<E, T>.onFailure(block: (E) -> Nothing): T = TODO()

interface Error{
    val msg: String
}

data class ThrowableError(val t: Throwable): Error {
    override val msg: String
        get() = t.message.orEmpty()
}

fun <T: Error> T.asFailure(): Outcome<T, Nothing> = Failure(this)
fun <T: Any> T.asSuccess(): Outcome<Nothing, T> = Success(this)