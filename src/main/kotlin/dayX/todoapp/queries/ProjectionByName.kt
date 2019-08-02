package dayX.todoapp.queries

import dayX.todoapp.errors.TodoError
import dayX.todoapp.events.*
import dayX.todoapp.fp.Outcome
import dayX.todoapp.fp.exhaustive

class ProjectionByName(
    projector: Projector<NameRow, String>,
    eventStore: EventStore<ToDoEvent, ItemId, ToDoItem>
) {

    fun updateFrom(orderedEvent: OrderedEvent<ToDoEvent>, projector: Projector<NameRow, String>) {
        with(projector) {
            when (orderedEvent.event) {
                is ToDoItemAdded -> insert(
                    NameRow(
                        key = orderedEvent.event.name,
                        itemId = orderedEvent.event.itemId
                    )
                )
                else -> Unit //nothing to do
            }.exhaustive
        }
    }

    val baseProjection = BaseProjection(projector, eventStore, ::updateFrom)

    fun getItem(name: String): Outcome<TodoError, List<NameRow>> = baseProjection.updatedProjector().getFiltered { it.key == name }


}
