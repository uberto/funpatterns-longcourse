package day1

data class FunStack<T>(private val items: List<T> = emptyList()){

    fun pop(): Pair<FunStack<T>, T?> =
        if(items.isEmpty()){
             this to null
        } else {
            FunStack(items.dropLast(1)) to items.last()
        }

    fun push(item: T): FunStack<T> = FunStack(items + item)

    fun size(): Int = items.size

}