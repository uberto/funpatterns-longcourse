package day7.todoapp.queries

import day7.todoapp.errors.TodoError
import day7.todoapp.events.EventId
import day7.todoapp.fp.Outcome

interface Projector<ROW : ProjectionRow<KEY>, KEY> {
    fun insert(newRow: ROW)

    fun replace(id: KEY, f: ROW.() -> ROW)

    fun getFiltered(pred: (ROW) -> Boolean): Outcome<TodoError, List<ROW>>

    fun getLastEventId(): EventId

    fun updateTo(eventId: EventId, block: Projector<ROW, KEY>.() -> Unit)

}
