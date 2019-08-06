package day3

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test


typealias ConfigReader = Reader<Map<*, String>, String?>

class ConfigReaderTest {

    val myConfig = mapOf(
        "server" to "myhost.com",
        "port" to "8080",
        "timeout" to "2s"
    )

    @Test
    fun `read configuration`(){
        val portR: ConfigReader = FunReader {it["port"]}
        val timeoutR: ConfigReader = FunReader {it["timeout"]}

        assertThat(portR.runReader(myConfig)).isEqualTo("8080")
        assertThat(timeoutR.runReader(myConfig)).isEqualTo("2s")

            }


    @Test
    fun `read modified configuration`(){
        val portR: ConfigReader = FunReader{it["port"]}
        val noPort: ConfigReader = portR.local { myConfig.minus("port") }

        assertThat(portR.runReader(myConfig)).isEqualTo("8080")
        assertThat(noPort.runReader(myConfig)).isEqualTo(null)

        }

}