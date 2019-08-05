package day2

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class SequenceTest {

    val names = listOf( "Frank", "John", "Mary", "Ann", "Fred")

    @Test
    fun `from f to Sequence`(){

        val iterNames = names.iterator()

        val seq = generateSequence { iterNames.nextOrNull() }

        assertThat( seq.toList()).isEqualTo(names)

    }

    @Test
    fun `from Sequence to f`(){

        val iterator = names.asSequence().iterator()

        val f = { iterator.nextOrNull()}

        assertThat(f() ).isEqualTo( "Frank")
        assertThat(f()).isEqualTo( "John")
        assertThat(f()).isEqualTo( "Mary")
        assertThat(f()).isEqualTo( "Ann")
        assertThat(f()).isEqualTo( "Fred")
        assertThat(f()).isEqualTo( null)
        assertThat(f()).isEqualTo( null)
    }
}