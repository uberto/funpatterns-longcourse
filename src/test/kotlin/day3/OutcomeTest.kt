package day3

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class OutcomeTest {

    fun readOrderFromDb(orderId: OrderId): Outcome<DbError, Order> =
        if (orderId == existingOrderId)
            Success(Order( existingOrderId, UserId(123), 123.4))
        else
            Failure(DbError("order $orderId does not exist"))

    fun readUserFromDb(id: UserId): Outcome<DbError, User> =
        Success(User(id, "Joe"))

    val existingOrderId = OrderId(123)
    val notExistingOrderId = OrderId(234)

    @Test
    fun `check for error cases`() {

        val res = readOrderFromDb(notExistingOrderId)
        when (res) {
            is Success -> fail("this order doesn't exit")
            is Failure -> assertThat(res.error).isEqualTo(DbError("order $notExistingOrderId does not exist"))
        }

    }

    @Test
    fun `map results`() {
        val amount: Double = readOrderFromDb(existingOrderId)
            .map { o -> o.amount }
            .onFailure { return }

        assertThat(amount).isEqualTo(123.4)
    }


    @Test
    fun `combine results`() {
        val userName: String = readOrderFromDb(existingOrderId)
            .flatMap { o -> readUserFromDb(o.userId) }
            .map { it.name }
            .onFailure { fail("Order and User should exist") }

        assertThat(userName).isEqualTo("Joe")
    }

}