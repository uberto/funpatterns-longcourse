package dayX.todoapp.application

import dayX.todoapp.commands.CommandHandler
import dayX.todoapp.events.ToDoEventPersistenceInMem
import dayX.todoapp.events.ToDoEventStore
import dayX.todoapp.queries.ProjectionAllItems
import dayX.todoapp.queries.ProjectionByName
import dayX.todoapp.queries.ProjectorInMem
import dayX.todoapp.queries.QueryHandler
import dayX.todoapp.webserver.ToDoHandler
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer

object TodoApp {

    fun createWebServer(port: Int): Http4kServer
        {
            val eventStore = ToDoEventStore(ToDoEventPersistenceInMem())

            return ToDoHandler(
                CommandHandler(eventStore),
                QueryHandler(ProjectionAllItems( ProjectorInMem(), eventStore), ProjectionByName( ProjectorInMem(), eventStore))
            ).asServer(Jetty(port))
        }


}
