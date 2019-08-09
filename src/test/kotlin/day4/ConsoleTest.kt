package day4

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import java.util.*

class ConsoleTest {

    val output = ArrayDeque<String>()
    val input = ArrayDeque<String>()

    val pseudoPrint: (String) -> Console<Unit> = { msg -> Console { output.add(msg); Unit } }
    val pseudoReadline: () -> Console<String> = { Console { input.remove() } }

    @Test
    fun `Echo Machine repeats every input`() {

        val echo = EchoMachine(pseudoPrint, pseudoReadline)

        input.add("Hello")
        input.add("Functional")
        input.add("World")

        echo()
        echo()
        echo()

        assertThat(output.remove()).isEqualTo("Hello")
        assertThat(output.remove()).isEqualTo("Functional")
        assertThat(output.remove()).isEqualTo("World")
    }


    @Test
    fun `A mini cmdline calculator`() {
        val calc = Calculator(pseudoPrint, pseudoReadline)

        input.add("3 4 5 + *")

        calc()

        assertThat(output.remove()).isEqualTo("27.0")

    }

    @Test
    fun `Many inputs give many results`() {
        val calc = Calculator(pseudoPrint, pseudoReadline)

        input.add("3 4 +")
        input.add("5 6 *")

        calc()
        calc()

        assertThat(output.remove()).isEqualTo("7.0")
        assertThat(output.remove()).isEqualTo("30.0")
    }

    @Test
    fun `Errors give messages`() {
        val calc = Calculator(pseudoPrint, pseudoReadline)

        input.add("5 6 @")

        calc()
        assertThat(output.remove()).isEqualTo("Unknown operation @")
    }


}