package dayX.todoapp.webserver

import dayX.todoapp.commands.CommandHandler
import dayX.todoapp.queries.QueryHandler
import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.then
import org.http4k.filter.ServerFilters
import org.http4k.routing.routes

class ToDoHandler(val commandHandler: CommandHandler, val queryHandler: QueryHandler): HttpHandler {


    override fun invoke(request: Request): Response {

        return ServerFilters.CatchLensFailure.then(
            routes(
                *(CommandRoutes(commandHandler)() + QueryRoutes(queryHandler)()).toTypedArray()
            )
        )(request)
    }

}

