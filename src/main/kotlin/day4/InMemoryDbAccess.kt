package day4

import day3.*

data class InMemoryDbAccess(private val orders: MutableList<Order>, private val users: MutableList<User>) : DbAccess {

    override fun nextUserId(): UserId = TODO()

    override fun nextOrderId(): OrderId = TODO()

    override fun OrderId.read(): Outcome<DbError, Order> = TODO()

    override fun UserId.read(): Outcome<DbError, User> = TODO()

    override fun Order.write(): Outcome<DbError, OrderId> = TODO()

    override fun User.write(): Outcome<DbError, UserId> = TODO()
}
