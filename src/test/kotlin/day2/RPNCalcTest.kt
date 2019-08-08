package day2

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RPNCalcTest {

    @Test
    fun `fist operand pop up 2 elements from stack`(){
        val expr = "4 5 +"

        val res = calc(expr)

        assertThat(res).isEqualTo(9.0)
    }

    @Test
    fun `numbers are pushed on the stack until requested`(){
        val expr = "3 2 1 + +"

        val res = calc(expr)

        assertThat(res).isEqualTo(6.0)
    }

    @Test
    fun `all operations pop number from stack`(){
        val expr = "5 3 5 4 5 + * / -"

        val res = calc(expr)

        assertThat(res).isEqualTo(10.0)
    }

    @Test
    fun `in case of no value return null`(){
        val expr = "+ * / -"

        val res = calc(expr)

        assertThat(res).isEqualTo(null)
    }
}