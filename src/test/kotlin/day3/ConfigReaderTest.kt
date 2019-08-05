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

    data class ConfigReader(val f: (String) -> String): Reader<String, String> {

        override fun ask(what: String): String = f(what)

    }

    @Test
    fun `read configuration`(){
        val configurator = ConfigReader(myConfig::getValue)

        assertThat(configurator.ask("port")).isEqualTo("8080")
        assertThat(configurator.ask("timeout")).isEqualTo("2s")
    }

}