@file:OptIn(ExperimentalUnsignedTypes::class)

package de.haw.landshut

import java.io.File

fun main() {
    val rom = File("src/main/resources/Chip8 Picture.ch8").readBytes()

    val chip8 = Chip8(rom.weaveToUShortArray(), screenWidth = 64, screenHeight = 32)

    repeat(100) {
        chip8.next()
        println(chip8.getScreen())
    }
}