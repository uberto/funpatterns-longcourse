package dayX.todoapp


import dayX.todoapp.application.TodoApp

fun main() {

    TodoApp.createWebServer (9000).start()

}