package day2

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CollatzConjectureTest {
    // https://en.wikipedia.org/wiki/Collatz_conjecture

    @Test
    fun `powers of two goes down to 1`() {
        assertThat(4.collatz()).isEqualTo(listOf(4, 2, 1))
        assertThat(8.collatz()).isEqualTo(listOf(8, 4, 2, 1))
        assertThat(32.collatz()).isEqualTo(listOf(32, 16, 8, 4, 2, 1))
    }

    @Test
    fun `odd numbers got multiplied by three plus one`() {
        assertThat(13.collatz()).isEqualTo(listOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1))
        assertThat(63.collatz()).isEqualTo(listOf(63, 190, 95, 286, 143, 430, 215, 646, 323, 970, 485, 1456, 728, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1))
    }

    @Test
    fun `generate the series of max value in the collatz series for each number`() {

        assertThat(collatzMax().take(11).toList().max()).isEqualTo(52)

        assertThat(collatzMax().take(101).toList().max()).isEqualTo(9232)

        assertThat(collatzMax().take(1001).toList().max()).isEqualTo(250504)

    }

}
