package day2

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class MonoidTest {

    @Test
    fun `Monoid naturally fold`() {
        with(Monoid(0, Int::plus)) {
            assertThat(listOf(1, 2, 3, 4, 10).fold()).isEqualTo(20)
        }
    }

    @Test
    fun `Monoid fold also Strings`() {
        with(Monoid("", String::plus)) {
            assertThat(listOf("My", "Fair", "Lady").fold()).isEqualTo("MyFairLady")
        }
    }


    @Test
    fun `Monoid fold also business types`() {
        with(Monoid(zeroMoney, Money::sum)) {
            assertThat(listOf(Money(2.1), Money(3.9), Money(4.0)).fold()).isEqualTo(Money(10.0))
        }
    }

    private val zeroMoney = Money(0.0)

    data class Money(val amount: Double){

        fun sum(other: Money) = Money(this.amount + other.amount)
    }
}




