package day1

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ScopeFunctionTest{

    private fun lastWord(phrase: String): String =TODO() //implement it in one line

    private fun firstWord(phrase: String): String =TODO() //implement it in one line


    @Test
    fun `let pass value and return result`(){

        val res = lastWord("hello world")

        assertThat(res).isEqualTo("world")
    }



    @Test
    fun `run call value method and return result`(){

        val res = firstWord("hello world")

        assertThat(res).isEqualTo("hello")
    }

}