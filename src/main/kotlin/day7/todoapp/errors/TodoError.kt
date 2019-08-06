package day7.todoapp.errors

data class TodoError(val msg: String, val e: Throwable? = null): Error() {

}
