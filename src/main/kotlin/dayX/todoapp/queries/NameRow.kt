package dayX.todoapp.queries

import dayX.todoapp.events.ItemId

data class NameRow(override val key: String, val itemId: ItemId): ProjectionRow<String>