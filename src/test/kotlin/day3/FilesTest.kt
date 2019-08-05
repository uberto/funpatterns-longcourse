package day3

import day2.nextOrNull
import org.junit.jupiter.api.Test
import java.nio.file.Path

class FilesTest {

    fun <T> Sequence<T>.callNext2(function: (T?) -> Any) {
        this.map(function)
        function(null)
    }

    val names = listOf("Frank", "John", "Mary", "Ann", "Fred").asSequence()


    @Test
    fun `write a file`() {

        val lines = names.iterator()

        val fw = FileWriter(Path.of("./names.txt"))

        fw {
            lines.nextOrNull()
        }

    }
}


