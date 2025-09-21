@file:OptIn(ExperimentalUnsignedTypes::class)

package de.haw.landshut

fun main() {
    val rom = ushortArrayOf(
        0xC00Fu,
    )
    val chip8 = Chip8(rom, screenWidth = 3, screenHeight = 3)

    chip8.display[2][0] = true

    println(chip8.getScreen())
}