package day4

import assertk.assertThat
import assertk.assertions.doesNotContain
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import day4.Sign.Cross
import day4.Sign.Nought
import org.junit.jupiter.api.Test

class TicTacToeTest {

    @Test
    fun `empty board`(){
        val b = TicTacToe.newBoard
        assertThat( b.render() ).doesNotContain("X")
        assertThat( b.render() ).doesNotContain("O")

        assertThat( b.row(Row.Middle)).isEqualTo(listOf(null, null, null))
    }

    @Test
    fun `first move`(){
        val b = TicTacToe.newBoard.placeMove(MiddleCenter(Cross))
        println( b!!.render() )

        assertThat( b.row(Row.Middle)).isEqualTo(listOf(null, Cross, null))
        assertThat( b.col(Col.Center)).isEqualTo(listOf(null, Cross, null))
    }

    @Test
    fun `fold moves`(){

        val moves = listOf(
            MiddleCenter(Cross),
            TopLeft(Nought),
            TopCenter(Cross),
            BottomCenter(Nought),
            MiddleLeft(Cross),
            MiddleRight(Nought),
            TopRight(Cross),
            BottomLeft(Nought)
        )
        val b = TicTacToe.newBoard.fold(moves)
        println( b!!.render() )

        assertThat( b.row(Row.Top)).isEqualTo(listOf(Nought, Cross, Cross))
        assertThat( b.row(Row.Middle)).isEqualTo(listOf(Cross, Cross, Nought))
        assertThat( b.row(Row.Bottom)).isEqualTo(listOf(Nought, Nought, null))
    }

    @Test
    fun `invalid move return null board`(){
        val b = TicTacToe.newBoard
            .placeMove(MiddleCenter(Cross))
            ?.placeMove(MiddleCenter(Nought))


        assertThat( b).isNull()
    }
}