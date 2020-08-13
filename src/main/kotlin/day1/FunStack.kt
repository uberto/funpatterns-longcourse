package day1

data class FunStack<T>(private val items: Collection<T>){

    fun pop(): Pair<T?, FunStack<T>> = TODO()

    fun push(item: T): FunStack<T> = TODO()

    fun size(): Int = items.size

}