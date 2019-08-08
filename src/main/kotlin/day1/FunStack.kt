package day1

data class FunStack<T>(private val items: List<T> = emptyList()){

    fun pop(): Pair<T?, FunStack<T>> =
        if(items.isEmpty()){
             null to this
        } else {
            items.last() to FunStack(items.dropLast(1))
        }

    fun push(item: T): FunStack<T> = FunStack(items + item)

    fun size(): Int = items.size

}