import de.haw.landshut.bitAt
import de.haw.landshut.combine
import de.haw.landshut.leftByte
import de.haw.landshut.leftNibble
import de.haw.landshut.rightByte
import de.haw.landshut.rightNibble
import de.haw.landshut.weaveToUShortArray
import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.*;
import java.util.Arrays

@OptIn(ExperimentalUnsignedTypes::class)
class UtilTest {

    @Test
    fun test_combine() {
        val left = 0xAFu.toUByte()
        val right = 0xFEu.toUByte()
        assertThat(left combine right).isEqualTo(0xAFFEu.toUShort())
    }

    @Test
    fun leftByte() {
        val uShort = 0xAFFE.toUShort()
        assertThat(uShort.leftByte).isEqualTo(0xAF.toUByte())
    }

    @Test
    fun rightByte() {
        val uShort = 0xAFFE.toUShort()
        assertThat(uShort.rightByte).isEqualTo(0xFE.toUByte())
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

    @Test
    fun test_leftNibble() {
        assertThat(0xAF.toUByte().leftNibble).isEqualTo(0xAu.toUByte())
    }

    @Test
    fun test_rightNibble() {
        assertThat(0xAF.toUByte().rightNibble).isEqualTo(0xFu.toUByte())
    }

    @Test
    fun waveToUShortArray() {
        val input = byteArrayOf(0xCA.toByte(), 0xFE.toByte(), 0xBA.toByte(), 0xBE.toByte())
        val expected = ushortArrayOf(0xCAFE.toUShort(), 0xBABE.toUShort())
        assertThat(input.weaveToUShortArray() contentEquals expected).isTrue
    }
}