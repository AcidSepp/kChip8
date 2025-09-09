import de.haw.landshut.Chip8
import de.haw.landshut.mask
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*;

@OptIn(ExperimentalUnsignedTypes::class)
class Test {

    @Test
    fun mask_worksCorrectly() {
        val input = 0xABCD.toUShort()

        assertThat(input mask 0xF000).isEqualTo(0xA000.toUShort())
    }

    @Test
    fun op6XNN() {
        val rom = ushortArrayOf(0x6AF0u, 0x6BF1u, 0x6CF2u, 0x6DF3u)
        val chip8 = Chip8(rom)
        chip8.next()
        chip8.next()
        chip8.next()
        chip8.next()

        assertThat(chip8.registers[0xA]).isEqualTo(0xF0.toUByte())
        assertThat(chip8.registers[0xB]).isEqualTo(0xF1.toUByte())
        assertThat(chip8.registers[0xC]).isEqualTo(0xF2.toUByte())
        assertThat(chip8.registers[0xD]).isEqualTo(0xF3.toUByte())
    }

    @Test
    fun op7XNN() {
        val rom = ushortArrayOf(0x7A01u, 0x7B02u, 0x7C03u, 0x7D04u)
        val chip8 = Chip8(rom)

        chip8.registers[0xA] = 1u
        chip8.registers[0xB] = 2u
        chip8.registers[0xC] = 3u
        chip8.registers[0xD] = 4u

        chip8.next()
        chip8.next()
        chip8.next()
        chip8.next()

        assertThat(chip8.registers[0xA]).isEqualTo(0x02.toUByte())
        assertThat(chip8.registers[0xB]).isEqualTo(0x04.toUByte())
        assertThat(chip8.registers[0xC]).isEqualTo(0x06.toUByte())
        assertThat(chip8.registers[0xD]).isEqualTo(0x08.toUByte())
    }

    @Test
    fun op8XY0() {
        val rom = ushortArrayOf(0x80A0u, 0x81B0u, 0x82C0u, 0x83D0u)
        val chip8 = Chip8(rom)

        chip8.registers[0xA] = 1u
        chip8.registers[0xB] = 2u
        chip8.registers[0xC] = 3u
        chip8.registers[0xD] = 4u

        chip8.next()
        chip8.next()
        chip8.next()
        chip8.next()

        assertThat(chip8.registers[0x0]).isEqualTo(0x01.toUByte())
        assertThat(chip8.registers[0x1]).isEqualTo(0x02.toUByte())
        assertThat(chip8.registers[0x2]).isEqualTo(0x03.toUByte())
        assertThat(chip8.registers[0x3]).isEqualTo(0x04.toUByte())
    }

    @Test
    fun op8XY1() {
        val rom = ushortArrayOf(0x80A1u, 0x81B1u, 0x82C1u, 0x83D1u)
        val chip8 = Chip8(rom)

        chip8.registers[0xA] = 0x0Au
        chip8.registers[0xB] = 0x0Bu
        chip8.registers[0xC] = 0x0Cu
        chip8.registers[0xD] = 0x0Du

        chip8.registers[0x0] = 0x10u
        chip8.registers[0x1] = 0x20u
        chip8.registers[0x2] = 0x30u
        chip8.registers[0x3] = 0x40u

        chip8.next()
        chip8.next()
        chip8.next()
        chip8.next()

        assertThat(chip8.registers[0x0]).isEqualTo(0x1A.toUByte())
        assertThat(chip8.registers[0x1]).isEqualTo(0x2B.toUByte())
        assertThat(chip8.registers[0x2]).isEqualTo(0x3C.toUByte())
        assertThat(chip8.registers[0x3]).isEqualTo(0x4D.toUByte())
    }
}