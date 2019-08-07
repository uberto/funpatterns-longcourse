package day4

enum class Sign {
    Nought,
    Cross
}

enum class Col {
    Left,Center,Right
}

enum class Row {
    Top,Middle,Bottom
}

sealed class Move(row: Row, col: Col) {
    abstract val sign: Sign
    val coord: Pos = Pos(row, col)
}

data class Pos(val row: Row, val col: Col)

data class TopLeft(override val sign: Sign) : Move(Row.Top, Col.Left)
data class TopCenter(override val sign: Sign) : Move(Row.Top, Col.Center)
data class TopRight(override val sign: Sign) : Move(Row.Top, Col.Right)
data class MiddleLeft(override val sign: Sign) : Move(Row.Middle, Col.Left)
data class MiddleCenter(override val sign: Sign) : Move(Row.Middle, Col.Center)
data class MiddleRight(override val sign: Sign) : Move(Row.Middle, Col.Right)
data class BottomLeft(override val sign: Sign) : Move(Row.Bottom, Col.Left)
data class BottomCenter(override val sign: Sign) : Move(Row.Bottom, Col.Center)
data class BottomRight(override val sign: Sign) : Move(Row.Bottom, Col.Right)

data class TicTacToe(private val pastMoves: List<Move>) {

    fun row(row: Row): List<Sign?> = listOf(
        Pos(row, Col.Left).sign(),
        Pos(row, Col.Center).sign(),
        Pos(row, Col.Right).sign())


    fun col(col: Col): List<Sign?> = listOf(
        Pos(Row.Top, col).sign(),
        Pos(Row.Middle, col).sign(),
        Pos(Row.Bottom, col).sign())

    fun render(): String = listOf(
        renderRow(Row.Top),
        renderRow(Row.Middle),
        renderRow(Row.Bottom)
    ).joinToString("\n---+---+---\n")

    private fun renderRow(r: Row) = " " + row(r).map { it.render() }.joinToString(separator = " | ")


    fun placeMove(move: Move): TicTacToe? =
        if (move.coord.sign() == null)
            TicTacToe(pastMoves + move)
        else
            null

    fun Pos.sign(): Sign? = pastMoves.firstOrNull{it.coord == this}?.sign

    fun Sign?.render(): Char = when (this){
        Sign.Nought -> 'O'
        Sign.Cross -> 'X'
        null -> ' '
    }
    fun fold(moves: List<Move>): TicTacToe? =
        moves.fold(this as TicTacToe?, {acc, m -> acc?.placeMove(m)})


    companion object {
        val newBoard: TicTacToe = TicTacToe(listOf())
    }
}
