package day5

import assertk.assertThat
import assertk.assertions.isEqualTo
import day1.FunStack
import org.junit.jupiter.api.Test

class StateTest() {

    fun pop(): State<FunStack<Int>, Int> = State { s -> s.pop() }
    fun push(a: Int): State<FunStack<Int>, Int> = State { s -> Pair(null, s.push(a)) }

    @Test
    fun `push only`() {

        val r = push(3).exec(FunStack())

        println("r $r")

    }

    @Test
    fun `push push`() {

        val r = push(3).flatMap { push(4) }.exec(FunStack())

        println("r $r")

    }

    @Test
    fun `push pop push push`() {

        val r =
            push(123).flatMap {
            pop().flatMap {
            assertThat(it).isEqualTo(123)

            push(42).flatMap {
            push(96)
        }}}.exec(FunStack())

        println("r $r")

    }
}