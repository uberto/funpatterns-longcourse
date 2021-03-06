package day1

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class FilterMapTest() {

    //to be able to return a List<U> you need to create it and add items to it
    fun <T : Any, U : Any> List<T>.filterMap(f: (T) -> U?): List<U> = TODO()


    @Test
    fun `filterMap transform values and remove the null ones`() {

        val names = listOf("Frank", "John", "Mary", "Ann", "Fred")

        val res = names.filterMap { n -> if (n.length == 4) n.first() else null }

        assertThat(res).isEqualTo(listOf('J', 'M', 'F'))

    }
}