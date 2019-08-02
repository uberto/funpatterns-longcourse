package day1

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import java.util.*

class CurryingTest {

    fun sum(num1: Int, num2: Int) = num1 + num2

    fun strConcat(s1: String, s2: String) = s1+s2

    data class Person( val creation: Date, val isCustomer: Boolean, val id: Int, val name: String )


    @Test
    fun `currying sum`(){

        val plus3 = ::sum.curry()(3)

        val plus7 = ::sum.curry()(7)

        assertThat(plus3( plus7(5))).isEqualTo(15)

    }


    @Test
    fun `currying concat`(){

        val starPrefix = ::strConcat.curry()("*")

        assertThat(starPrefix("abc")).isEqualTo("*abc")

    }


    @Test
    fun `currying Person`(){

        val now = Date()
        val fred =
            CurryingTest::Person.curry() `@` now `@` false `@` 4 `@` "Fred"

        val fredOrig =
            Person(now, false, 4, "Fred")

        assertThat(fred).isEqualTo(fredOrig)

    }

    @Test
    fun `creating People`(){

        val personPartBuilder =
            CurryingTest::Person.curry()  `@` Date() `@` true

        val name = listOf("Fred", "Mary", "Ann", "Bob")

        val people = name.mapIndexed{ i, n ->
            personPartBuilder(i)(n)
        }


        assertThat(people).hasSize(name.size)

    }

}