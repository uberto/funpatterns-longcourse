package day4

import assertk.assertThat
import assertk.assertions.isEqualTo
import day3.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class DbAccessTest {

    val db = InMemoryDbAccess(mutableListOf(), mutableListOf())

    private fun <E: Error, T: Any> Outcome<E, T>.expectSuccess(): T = this.onFailure { fail(it.msg) }

    fun DbAccess.getUserNameFromOrder(orderId: OrderId): Outcome<DbError, String> = TODO("implement it with flatmap")

    fun DbAccess.newOrderWithAmountFromAnotherOrderAndUserFromUserId(orderId: OrderId, userId: UserId): Outcome<DbError, OrderId> =
        TODO("implement it with flatmap")

    private fun preparedDb() =
        db.apply {
            val bob = User(UserId(1), "Bob").write().expectSuccess()

            val alice = User(UserId(2), "Alice").write().expectSuccess()

            Order(OrderId(1), bob, 123.4).write().expectSuccess()

            Order(OrderId(2), alice, 234.5).write().expectSuccess()
        }


    @Test
    fun `read user name from order`() {

        val userName = preparedDb().getUserNameFromOrder(OrderId(1)).expectSuccess()

        assertThat(userName).isEqualTo("Bob")

    }

    @Test
    fun `duplicate order with same amount a new user`() {

        with(preparedDb()) {
            val newId = newOrderWithAmountFromAnotherOrderAndUserFromUserId(OrderId(1), UserId(2))

            newId.map {
                val o = it.read().expectSuccess()

                assertThat( o.id ).isEqualTo(OrderId(3))

                assertThat( o.userId ).isEqualTo(UserId(2))
                assertThat( o.amount ).isEqualTo(123.4)
            }.expectSuccess()

        }

    }

}