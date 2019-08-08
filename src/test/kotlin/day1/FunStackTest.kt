package day1

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test

class FunStackTest (){

    @Test
    fun `push increase the size`(){
        val stack = FunStack<Char>().push('A')

        assertThat(stack.size()).isEqualTo(1)
    }

    @Test
    fun `pop decrease the size and return the last pushed value`(){
        val (c, stack) = FunStack<Char>().push('Q').pop()

        assertThat(stack.size()).isEqualTo(0)
        assertThat(c).isEqualTo('Q')
    }

    @Test
    fun `pop return null when stack is empty`(){
        val (c, stack) = FunStack<Char>().pop()

        assertThat(stack.size()).isEqualTo(0)
        assertThat(c).isNull()
    }

    @Test
    fun `push push pop pop`(){
        val s0 = FunStack<Char>()

        val s1 = s0.push('A')
        val s2 = s1.push('B')
        val (b,s3) = s2.pop()
        val (a, s4) = s3.pop()

        assertThat(b).isEqualTo('B')
        assertThat(a).isEqualTo('A')
        assertThat(s4.size()).isEqualTo(0)
    }
}