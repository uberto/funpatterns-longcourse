package day3

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import day2.nextOrNull
import org.junit.jupiter.api.Test

class FilesTest {

    val names = listOf("Frank", "John", "Mary", "Ann", "Fred", "Andy")

    private val filePath = Path("./names.txt")

    @Test
    fun `write a file`() {

        val lines = names.iterator()

        val fw = FileWriter(filePath)

        val res = fw { lines.nextOrNull() }

        assertThat(res).isInstanceOf(Success::class)

        assertThat(names).isEqualTo(filePath.toFile().readLines())

    }


    @Test
    fun `read a file`() {

        val fr = FileReader(filePath)

        val res = fr { it }

        assertThat(res).isEqualTo(Success(names))

    }
}


