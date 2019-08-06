package day1

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ScopeFunctionTest {

    //implement them in one line (using lastIndexOf or indexOf)

    private fun lastWord(phrase: String): String {
        val lastSpace = phrase.lastIndexOf(' ')
        if (lastSpace == -1)
            return phrase
        return phrase.substring(lastSpace + 1)
    }


    private fun firstWord(phrase: String): String {
        val firstSpace = phrase.indexOf(' ')
        if (firstSpace == -1)
            return phrase
        return phrase.substring(0, firstSpace)
    }

    @Test
    fun `let pass value and return result`() {

        val res = lastWord("hello world")

        assertThat(res).isEqualTo("world")
    }


    @Test
    fun `run call value method and return result`() {

        val res = firstWord("hello world")

        assertThat(res).isEqualTo("hello")
    }

}