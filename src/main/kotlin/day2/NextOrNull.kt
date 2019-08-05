package day2


fun <T> Iterator<T>.nextOrNull(): T? =
    if (hasNext()) next() else null
