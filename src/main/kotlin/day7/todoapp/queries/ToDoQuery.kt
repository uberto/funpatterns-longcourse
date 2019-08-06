package day7.todoapp.queries

import day7.todoapp.events.ItemId



sealed class ToDoQuery

object allItems: ToDoQuery()
object allOpenItems: ToDoQuery()
data class singleItemById(val id: ItemId): ToDoQuery()
data class singleItemByName(val name: String): ToDoQuery()