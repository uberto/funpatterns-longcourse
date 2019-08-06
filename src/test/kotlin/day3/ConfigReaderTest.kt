package day3

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ConfigReaderTest {

    val myConfig = mapOf(
        "server" to "myhost.com",
        "port" to "8080",
        "timeout" to "2s"
    )

    data class ConfigReader(val runner: ((String) -> String) -> String): Reader<(String) -> String, String> {
        override fun ((String) -> String).runReader(f: (String) -> Unit) = TODO()

        override fun ask(context: (String) -> String): String = TODO()

    }

    @Test
    fun `read configuration`(){
        val portR = ConfigReader({it("port")})
        val timeoutR = ConfigReader({it("timeout")})

        val context: (String) -> String = myConfig::getValue
        assertThat(portR.ask(context)).isEqualTo("8080")

        with(timeoutR) {
            context.runReader {
                assertThat(it).isEqualTo("2s")
            }
        }
    }
}