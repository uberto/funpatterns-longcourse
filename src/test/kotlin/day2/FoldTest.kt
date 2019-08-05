package day2

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class FoldTest {

    @Test
    fun `fold can reduce to a sum`(){

        val values = listOf(1,2,3,4,10)

        val tot = values.fold(0, TODO())

        assertThat(tot).isEqualTo(20)
    }

    @Test
    fun `fold can remove spaces`(){

        val values = "London Bridge Is Falling Down"

        val tot = values.fold("", TODO())

        assertThat(tot).isEqualTo("LondonBridgeIsFallingDown")
    }

    @Test
    fun `fold can reverse a String`(){

        val values = "London Bridge Is Falling Down"

        val tot = values.fold("", TODO())

        assertThat(tot).isEqualTo("nwoD gnillaF sI egdirB nodnoL")
    }



    @Test
    fun `fold can change a State Machine`(){

        val values = listOf(Up, Up, Down, Up, Down, Down, Up, Up, Up, Down)

        val tot = values.fold(Elevator(0), TODO())

        assertThat(tot).isEqualTo(Elevator(2))
    }

}