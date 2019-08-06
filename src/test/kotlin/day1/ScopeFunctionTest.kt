package day1

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ScopeFunctionTest{

    private fun lastWord(phrase: String) = phrase.lastIndexOf(' ').let { if (it < 0) phrase else phrase.substring(it + 1) }

    private fun firstWord(phrase: String) = phrase.run { substring( 0, indexOf(' ') ) }

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