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

}