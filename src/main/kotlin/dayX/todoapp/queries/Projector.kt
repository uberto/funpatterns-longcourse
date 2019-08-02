package dayX.todoapp.queries

import dayX.todoapp.errors.TodoError
import dayX.todoapp.events.EventId
import dayX.todoapp.fp.Outcome

interface Projector<ROW : ProjectionRow<KEY>, KEY> {
    fun insert(newRow: ROW)

    fun replace(id: KEY, f: ROW.() -> ROW)

    fun getFiltered(pred: (ROW) -> Boolean): Outcome<TodoError, List<ROW>>

    fun getLastEventId(): EventId

    fun updateTo(eventId: EventId, block: Projector<ROW, KEY>.() -> Unit)

}
