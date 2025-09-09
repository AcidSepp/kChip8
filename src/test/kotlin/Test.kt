import de.haw.landshut.mask
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*;

class Test {

    @Test
    fun mask_worksCorrectly() {
        val input = 0xABCD.toUShort()

        assertThat(input mask 0xF000).isEqualTo(0xA000.toUShort())
    }
}