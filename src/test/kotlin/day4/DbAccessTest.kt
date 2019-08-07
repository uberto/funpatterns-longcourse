package day4

import assertk.assertThat
import assertk.assertions.isEqualTo
import day3.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class DbAccessTest {

    val db = InMemoryDbAccess(mutableListOf(), mutableListOf())

    private fun preparedDb() =
        db.apply {
            val bob = User(UserId(1), "Bob").write().onFailure { fail(it.msg) }

            val alice = User(UserId(2), "Alice").write().onFailure { fail(it.msg) }

            Order(OrderId(1), bob, 123.4).write().onFailure { fail(it.msg) }

            Order(OrderId(2), alice, 234.5).write().onFailure { fail(it.msg) }
        }


    @Test
    fun `read user name from order`(){

        with(preparedDb()){

            val order = OrderId(1).read()
            val user = order.flatMap {
                it.userId.read().map { it.name }
            }

            assertThat(user).isEqualTo("Bob")
        }
    }

}