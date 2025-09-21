import de.haw.landshut.bitAt
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

    @Test
    fun test_bitAt() {
        assertThat(0x1u.toUByte().bitAt(0)).isEqualTo(true)
        assertThat(0x1u.toUByte().bitAt(1)).isEqualTo(false)
        assertThat(0x1u.toUByte().bitAt(2)).isEqualTo(false)
        assertThat(0x1u.toUByte().bitAt(3)).isEqualTo(false)
        assertThat(0x1u.toUByte().bitAt(4)).isEqualTo(false)
        assertThat(0x1u.toUByte().bitAt(5)).isEqualTo(false)
        assertThat(0x1u.toUByte().bitAt(6)).isEqualTo(false)
        assertThat(0x1u.toUByte().bitAt(7)).isEqualTo(false)
    }
}