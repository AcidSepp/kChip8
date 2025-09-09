@file:OptIn(ExperimentalUnsignedTypes::class)

package de.haw.landshut

import kotlin.experimental.and
import kotlin.math.pow

/**
 * see https://en.wikipedia.org/wiki/CHIP-8
 */
class Chip8(var instructions: UShortArray) {

    private var programmCounter = 0

    private val memory = ByteArray(2 pow 16)
    private val registers = ByteArray(16)
    private var addressRegister:  Short = 0

    private var stack = ByteArray(2 pow 8)
    private val stackPointer: Byte = 0

    fun next() {
        val op = instructions[programmCounter]

        val nnn = op mask 0x0FFF
        val nn = op.rightByte()
        val x = (op mask 0x0F00).leftByte()
        val y = (op mask 0x00F0).rightByte()

        if (op mask 0xFF00 == 0x0000.toUShort()) {
            if (op mask 0xFF00 == 0x0000.toUShort()) {
                if (op == 0x00E0.toUShort()) {
                    op00E0()
                }
                if (op == 0x00EE.toUShort()) {
                    op00EE()
                }
            } else {
                op0NNN(nnn)
            }
        }

        if (op mask 0xF000 == 0x1000.toUShort()) {
            op1NNN(nnn)
        }

        if (op mask 0xF000 == 0x2000.toUShort()) {
            op2NNN(nnn)
        }

        if (op mask 0xF000 == 0x3000.toUShort()) {
            op3XNN(x, nn)
        }

        if (op mask 0xF000 == 0x4000.toUShort()) {
            op4XNN(x, nn)
        }

        if (op mask 0xF000 == 0x5000.toUShort()) {
            op5XY0(x, y)
        }

        if (op mask 0xF000 == 0x6000.toUShort()) {
            op6XNN(x, nn)
        }

        if (op mask 0xF000 == 0x7000.toUShort()) {
            op7XNN(x, nn)
        }

        if (op mask 0xF00F == 0x8000.toUShort()) {
            op5XY0(x, y)
        }

        if (op mask 0xF00F == 0x8000.toUShort()) {
            op8XY0(x, y)
        }

        if (op mask 0xF00F == 0x8001.toUShort()) {
            op8XY1(x, y)
        }

        if (op mask 0xF00F == 0x8002.toUShort()) {
            op8XY2(x, y)
        }

        if (op mask 0xF00F == 0x8003.toUShort()) {
            op8XY3(x, y)
        }

        if (op mask 0xF00F == 0x8004.toUShort()) {
            op8XY4(x, y)
        }

        if (op mask 0xF00F == 0x8005.toUShort()) {
            op8XY5(x, y)
        }

        if (op mask 0xF00F == 0x8006.toUShort()) {
            op8XY6(x, y)
        }

        if (op mask 0xF00F == 0x8007.toUShort()) {
            op8XY7(x, y)
        }

        if (op mask 0xF00F == 0x800E.toUShort()) {
            op8XYE(x, y)
        }

        if (op mask 0xF000 == 0x9000.toUShort()) {
            op9XY0(x, y)
        }

        if (op mask 0xF000 == 0xA000.toUShort()) {
            opANNN(nnn)
        }

        if (op mask 0xF000 == 0xB000.toUShort()) {
            opBNNN(nnn)
        }

        if (op mask 0xF000 == 0xC000.toUShort()) {
            opCXNN(x, nn)
        }

        if (op mask 0xF000 == 0xD000.toUShort()) {
            opDXY0(x, y)
        }

        if (op mask 0xF0FF == 0xE09E.toUShort()) {
            opEX9E(x)
        }

        if (op mask 0xF0FF == 0xE0A1.toUShort()) {
            opEXA1(x)
        }

        if (op mask 0xF0FF == 0xF007.toUShort()) {
            opFX07(x)
        }

        if (op mask 0xF0FF == 0xF00A.toUShort()) {
            opFX0A(x)
        }

        if (op mask 0xF0FF == 0xF015.toUShort()) {
            opFX15(x)
        }

        if (op mask 0xF0FF == 0xF018.toUShort()) {
            opFX18(x)
        }

        if (op mask 0xF0FF == 0xF01E.toUShort()) {
            opFX1E(x)
        }

        if (op mask 0xF0FF == 0xF029.toUShort()) {
            opFX29(x)
        }

        if (op mask 0xF0FF == 0xF033.toUShort()) {
            opFX33(x)
        }

        if (op mask 0xF0FF == 0xF055.toUShort()) {
            opFX55(x)
        }

        if (op mask 0xF0FF == 0xF065.toUShort()) {
            opFX65(x)
        }
    }

    private fun opFX65(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX55(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX33(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX29(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX1E(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX18(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX15(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX0A(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opFX07(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opEXA1(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opEX9E(x: UByte) {
        TODO("Not yet implemented")
    }

    private fun opDXY0(x: UByte, y: UByte) {
        TODO("Not yet implemented")
    }

    fun op0NNN(nnn: UShort) {

    }

    fun op00E0() {

    }

    fun op00EE() {

    }

    fun op1NNN(nnn: UShort) {

    }

    fun op2NNN(nnn: UShort) {

    }

    fun op3XNN(x: UByte, nn: UByte) {

    }

    fun op4XNN(x: UByte, nn: UByte) {

    }

    fun op5XY0(x: UByte, y: UByte) {

    }

    fun op6XNN(x: UByte, nn: UByte) {

    }

    fun op7XNN(x: UByte, nn: UByte) {

    }

    fun op8XY0(x: UByte, y: UByte) {

    }

    fun op8XY1(x: UByte, y: UByte) {

    }

    fun op8XY2(x: UByte, y: UByte) {

    }

    fun op8XY3(x: UByte, y: UByte) {

    }

    fun op8XY4(x: UByte, y: UByte) {

    }

    fun op8XY5(x: UByte, y: UByte) {

    }

    fun op8XY6(x: UByte, y: UByte) {

    }

    fun op8XY7(x: UByte, y: UByte) {

    }

    fun op8XYE(x: UByte, y: UByte) {

    }

    fun op9XY0(x: UByte, y: UByte) {

    }

    fun opANNN(nnn: UShort) {

    }

    fun opBNNN(nnn: UShort) {

    }

    fun opCXNN(x: UByte, nn: UByte) {

    }
}

infix fun Int.pow(exponent: Int) = this.toDouble().pow(exponent).toInt()

infix fun UShort.mask(mask: Int) = this.and(mask.toUShort())

fun UShort.leftByte() = (this.toUInt() shr 8).toUByte()

fun UShort.rightByte() = this.toUByte()