package dayX.todoapp.queries

import dayX.todoapp.events.EventStore
import dayX.todoapp.events.OrderedEvent

class BaseProjection<ROW: ProjectionRow<KEY>, KEY, EVENT>(
    val projector: Projector<ROW, KEY>,
    val eventStore: EventStore<EVENT, KEY, *>,
    val updateFrom: (OrderedEvent<EVENT>, Projector<ROW, KEY>) -> Unit
) {

    fun updatedProjector(): Projector<ROW, KEY> {
        eventStore.fetchAll(projector.getLastEventId()).forEach { projector.updateTo(it.id) { updateFrom(it, this) }  }
        return projector
    }

}


