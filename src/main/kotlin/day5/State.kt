package day5

data class State<S : Any, A>(val runState: (S) -> Pair<A?, S>) {

    companion object {
        fun <S : Any, A> ret(a: A): State<S, A> = State { s: S -> a to s }
        fun <S : Any, A> put(s: S): State<S, A> = State { null to s }
        fun <S : Any> get(s: S): State<S, S> = State { s to s }
    }

    fun eval(s: S): A? = runState(s).first

    fun exec(s: S): S = runState(s).second

    fun <B> map(f: (A) -> B): State<S, B> = State { s -> runState(s).let { (a, s) -> a?.let { f(a) } to s } }

    fun <B> flatMap(f: (A?) -> State<S, B>): State<S, B> =
        State { s1 -> runState(s1).let { (a, s2) -> a.let { f(a).runState(s2) } } }

}
