package day1

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ScopeFunctionTest{

    private fun lastWord(phrase: String) = phrase.lastIndexOf(' ').let { if (it < 0) phrase else phrase.substring(it + 1) }

    @Test
    fun `let pass value and return result`(){

        val res = greetings().let { if(it.contains(' ')) lastWord(it) else it }

        assertThat(res).isEqualTo("world")
    }



    @Test
    fun `run call value method and return result`(){

        val res = greetings().run { substring( 0, indexOf(' ') ) }

        assertThat(res).isEqualTo("hello")
    }

    private fun greetings() = "hello world"
}