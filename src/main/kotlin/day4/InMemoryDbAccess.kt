package day4

import day3.*

data class InMemoryDbAccess(private val orders: MutableList<Order>, private val users: MutableList<User>) : DbAccess {


    override fun OrderId.read(): Outcome<DbError, Order> =
        orders.firstOrNull { it.id == this }?.asSuccess()
            ?: DbError("Order not present ${this.id}").asFailure()

    override fun UserId.read(): Outcome<DbError, User> =
        users.firstOrNull { it.id == this }?.asSuccess()
            ?: DbError("User not present ${this.id}").asFailure()


    override fun Order.update(): Outcome<DbError, Unit> =
        this.id.read().map {
            orders.remove(it)
            orders.add(this)
            Unit
        }.mapFailure {
            DbError("Updated failed: ${it.msg}")
        }


    override fun User.update(): Outcome<DbError, Unit> =
        this.id.read().map {
            users.remove(it)
            users.add(this)
            Unit
        }.mapFailure {
            DbError("Updated failed: ${it.msg}")
        }

    override fun Order.write(): Outcome<DbError, OrderId> =
        orders.firstOrNull { it.id == this.id }?.let {
            DbError("User already exists $it").asFailure()
        } ?: orders.add(this).let {
            this.id.asSuccess()
        }

    override fun User.write(): Outcome<DbError, UserId> =
        users.firstOrNull { it.id == this.id }?.let {
            DbError("User already exists $it").asFailure()
        } ?: users.add(this).let {
            this.id.asSuccess()
        }
}
