package day7.todoapp


import day7.todoapp.application.TodoApp

fun main() {

    TodoApp.createWebServer (9000).start()

}