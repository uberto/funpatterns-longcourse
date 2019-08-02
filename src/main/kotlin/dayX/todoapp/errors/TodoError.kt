package dayX.todoapp.errors

data class TodoError(val msg: String, val e: Throwable? = null): Error() {

}
