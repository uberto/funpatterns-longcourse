package day3

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class LogWriterTest {

    data class Logger(val lines: MutableList<String>) : Writer<String> {
        override fun runWriter(f: () -> String?) {
            f()?.let { lines.add(it) }
        }
    }

    @Test
    fun `logger with writer`() {

        val myLogs = mutableListOf<String>()

        val logger = Logger(myLogs)

        logger.runWriter { "Log this" }
        logger.runWriter { "Log that" }

        assertThat(myLogs.toList()).isEqualTo(listOf("Log this", "Log that"))
    }
}