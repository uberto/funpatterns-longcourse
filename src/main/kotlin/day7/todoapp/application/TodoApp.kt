package day7.todoapp.application

import day7.todoapp.commands.CommandHandler
import day7.todoapp.events.ToDoEventPersistenceInMem
import day7.todoapp.events.ToDoEventStore
import day7.todoapp.queries.ProjectionAllItems
import day7.todoapp.queries.ProjectionByName
import day7.todoapp.queries.ProjectorInMem
import day7.todoapp.queries.QueryHandler
import day7.todoapp.webserver.ToDoHandler
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
