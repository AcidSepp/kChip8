import de.haw.landshut.combine
import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.*;

class UtilTest {

    @Test
    fun test_combine() {
        val left = 0xAFu.toUByte()
        val right = 0xFEu.toUByte()

        assertThat(left combine right).isEqualTo(0xAFFEu.toUShort())
    }
}