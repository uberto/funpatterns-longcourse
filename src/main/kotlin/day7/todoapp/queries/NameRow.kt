package day7.todoapp.queries

import day7.todoapp.events.ItemId

data class NameRow(override val key: String, val itemId: ItemId): ProjectionRow<String>