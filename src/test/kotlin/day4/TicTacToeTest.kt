package day4

import assertk.assertThat
import assertk.assertions.doesNotContain
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import day4.Col.*
import day4.Row.*
import day4.Sign.Cross
import day4.Sign.Nought
import org.junit.jupiter.api.Test

class TicTacToeTest {

    @Test
    fun `empty board`() {
        val b = TicTacToe.newBoard
        assertThat(b.render()).doesNotContain("X")
        assertThat(b.render()).doesNotContain("O")

        assertThat(b.row(Middle)).isEqualTo(listOf(null, null, null))
    }

    @Test
    fun `first move`() {
        val b = TicTacToe.newBoard.place(Move(Middle, Center, Cross))
        println(b!!.render())

        assertThat(b.row(Middle)).isEqualTo(listOf(null, Cross, null))
        assertThat(b.col(Center)).isEqualTo(listOf(null, Cross, null))
    }

    @Test
    fun `fold moves`() {

        val moves = listOf(
            Move(Middle, Center, Cross),
            Move(Top, Left, Nought),
            Move(Top, Center, Cross),
            Move(Bottom, Center, Nought),
            Move(Middle, Left, Cross),
            Move(Middle, Right, Nought),
            Move(Top, Right, Cross),
            Move(Bottom, Left, Nought)
        )
        val b = TicTacToe.newBoard.fold(moves)
        println(b!!.render())

        assertThat(b.row(Top)).isEqualTo(listOf(Nought, Cross, Cross))
        assertThat(b.row(Middle)).isEqualTo(listOf(Cross, Cross, Nought))
        assertThat(b.row(Bottom)).isEqualTo(listOf(Nought, Nought, null))
    }

    @Test
    fun `invalid move return null board`() {
        val b = TicTacToe.newBoard
            .place(Move(Middle, Center, Cross))
            ?.place(Move(Middle, Center, Nought))


        assertThat(b).isNull()
    }

    @Test
    fun `get winner`() {
        val moves = listOf(
            Move(Middle, Center, Cross),
            Move(Top, Left, Nought),
            Move(Top, Center, Cross),
            Move(Bottom, Left, Nought)
        )
        val b1 = TicTacToe.newBoard.fold(moves)!!

        assertThat(b1.winner()).isNull()

        val b2 = b1.place(Move(Bottom, Center, Cross))!!
        assertThat(b2.winner()).isEqualTo(Cross)

        println(b2.render())
    }


    @Test
    fun `get winner in diagonals`() {
        val moves = listOf(
            Move(Middle, Center, Cross),
            Move(Top, Center, Nought),
            Move(Middle, Left, Cross),
            Move(Middle, Right, Nought),
            Move(Top, Left, Cross),
            Move(Bottom, Left, Nought),
            Move(Bottom, Right, Cross)
        )
        val b = TicTacToe.newBoard.fold(moves)!!
        println(b.render())
        assertThat(b.winner()).isEqualTo(Cross)

    }
}