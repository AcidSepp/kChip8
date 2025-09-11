@file:OptIn(ExperimentalUnsignedTypes::class)

package de.haw.landshut

import kotlin.experimental.and
import kotlin.math.pow

/**
 * see https://en.wikipedia.org/wiki/CHIP-8
 * sse https://chip8.gulrak.net/
 */
class Chip8(instructions: UShortArray) {

    val memory = UByteArray(2 pow 16)
    init {
        instructions.forEachIndexed { index, it ->
            memory[index * 2] = it.leftByte()
            memory[index * 2 + 1] = it.rightByte()
        }
    }

    private var programmCounter: UShort = 0.toUShort()

    val registers = UByteArray(16)

    var vf: UByte
        get() = registers[0xF]
        set(value) {
            registers[0xF] = value
        }

    var addressRegister: UShort = 0u
        private set

    private var stack = ByteArray(2 pow 8)
    private val stackPointer: Byte = 0

    fun next() {
        val op = getNextOp()

        println(op.toHexString())

        val nnn = op mask 0x0FFF
        val nn = op.rightByte()
        val x = (op mask 0x0F00).leftByte()
        val y = ((op mask 0x00F0) shr 4) .toUByte()

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

    /**
     * Calls machine code routine (RCA 1802 for COSMAC VIP) at address NNN.
     * Not necessary for most ROMs.
     */
    fun op0NNN(nnn: UShort) {

    }

    /**
     * Clears the screen.
     */
    fun op00E0() {

    }

    /**
     * Returns from a subroutine.
     */
    fun op00EE() {

    }

    /**
     * Jumps to address NNN.
     */
    fun op1NNN(nnn: UShort) {
        programmCounter = nnn
    }

    /**
     * Calls subroutine at NNN.
     */
    fun op2NNN(nnn: UShort) {
        programmCounter = nnn
        TODO()
    }

    /**
     * Skips the next instruction if VX equals NN (usually the next instruction
     * is a jump to skip a code block).
     */
    fun op3XNN(x: UByte, nn: UByte) {
        if (registers[x] == nn) {
            incrementProgrammCounter()
        }
        incrementProgrammCounter()
    }

    /**
     * Skips the next instruction if VX does not equal NN
     * (usually the next instruction is a jump to skip a code block).
     */
    fun op4XNN(x: UByte, nn: UByte) {
        if (registers[x] != nn) {
            incrementProgrammCounter()
        }
        incrementProgrammCounter()
    }

    /**
     * Skips the next instruction if VX equals VY
     * (usually the next instruction is a jump to skip a code block).
     */
    fun op5XY0(x: UByte, y: UByte) {
        if (registers[x] == registers[y]) {
            incrementProgrammCounter()
        }
        incrementProgrammCounter()
    }

    /**
     * Sets VX to NN.
     */
    fun op6XNN(x: UByte, nn: UByte) {
        registers[x] = nn
        incrementProgrammCounter()
    }

    /**
     * Adds NN to VX (carry flag is not changed).
     */
    fun op7XNN(x: UByte, nn: UByte) {
        val i = (registers[x] + nn).toUByte()
        registers[x] = i
        incrementProgrammCounter()
    }

    /**
     * Sets VX to the value of VY.
     */
    fun op8XY0(x: UByte, y: UByte) {
        registers[x] = registers[y]
        incrementProgrammCounter()
    }

    /**
     * Sets VX to VX or VY. (bitwise OR operation)
     */
    fun op8XY1(x: UByte, y: UByte) {
        registers[x] = registers[x] or registers[y]
        incrementProgrammCounter()
    }

    /**
     * Sets VX to VX and VY. (bitwise AND operation).
     */
    fun op8XY2(x: UByte, y: UByte) {
        registers[x] = registers[x] and registers[y]
        incrementProgrammCounter()
    }

    /**
     * Sets VX to VX xor VY.
     */
    fun op8XY3(x: UByte, y: UByte) {
        registers[x] = registers[x] xor registers[y]
        incrementProgrammCounter()
    }

    /**
     * add vY to vX, vF is set to 1 if an overflow happened, to 0 if not, even if X=F!
     */
    fun op8XY4(x: UByte, y: UByte) {
        val result = registers[x].toUInt() + registers[y].toUInt()
        registers[x] = result.toUByte()
        vf = if (result > UByte.MAX_VALUE) {
            0x1u
        } else {
            0x0u
        }
        incrementProgrammCounter()
    }

    /**
     * subtract vY from vX, vF is set to 0 if an underflow happened, to 1 if not, even if X=F!
     */
    fun op8XY5(x: UByte, y: UByte) {
        val result = registers[x].toInt() - registers[y].toInt()
        registers[x] = result.toUByte()
        vf = if (result < 0) {
            0x1u
        } else {
            0x0u
        }
        incrementProgrammCounter()
    }

    /**
     * set vX to vY and shift vX one bit to the right,
     * set vF to the bit shifted out, even if X=F!
     */
    fun op8XY6(x: UByte, y: UByte) {
        val rightMostBit = registers[y].mask(0b0000_0001)
        registers[x] = registers[y].shr(1)
        vf = rightMostBit
        incrementProgrammCounter()
    }

    /**
     * set vX to the result of subtracting vX from vY,
     * vF is set to 0 if an underflow happened, to 1 if not, even if X=F!
     */
    fun op8XY7(x: UByte, y: UByte) {
        val result = registers[y].toInt() - registers[x].toInt()
        registers[x] = result.toUByte()
        vf = if (result < 0) {
            0x1u
        } else {
            0x0u
        }
        incrementProgrammCounter()
    }

    /**
     * 	set vX to vY and shift vX one bit to the left,
     * 	set vF to the bit shifted out, even if X=F!
     */
    fun op8XYE(x: UByte, y: UByte) {
        val leftmostBit = registers[y].mask(0b1000_0000).shr(7)
        registers[x] = registers[y].shl(1)
        vf = leftmostBit
        incrementProgrammCounter()
    }

    /**
     * skip next opcode if vX != vY
     */
    fun op9XY0(x: UByte, y: UByte) {
        if (registers[x] != registers[y]) {
            incrementProgrammCounter()
        }
        incrementProgrammCounter()
    }

    /**
     * set I to NNN
     */
    fun opANNN(nnn: UShort) {
        addressRegister = memory[nnn.toInt()].toUShort()
        incrementProgrammCounter()
    }

    /**
     * jump to address NNN + v0
     */
    fun opBNNN(nnn: UShort) {
        programmCounter = (nnn + registers[0x0]).toUShort()
    }

    fun opCXNN(x: UByte, nn: UByte) {

    }

    private fun getNextOp() = memory[programmCounter.toInt()] combine memory[programmCounter.toInt() + 1]

    private fun incrementProgrammCounter() {
        programmCounter++
        programmCounter++
    }
}

infix fun Int.pow(exponent: Int) = this.toDouble().pow(exponent).toInt()

infix fun UShort.mask(mask: Int) = this.and(mask.toUShort())

infix fun UByte.mask(mask: Int) = this.and(mask.toUByte())

fun UShort.leftByte() = (this.toUInt() shr 8).toUByte()

fun UShort.rightByte() = this.toUByte()

infix fun UShort.shr(shift: Int) = (this.toUInt() shr shift).toUShort()

infix fun UShort.shl(shift: Int) = (this.toUInt() shl shift).toUShort()

infix fun UByte.shr(shift: Int) = (this.toUInt() shr shift).toUByte()

infix fun UByte.shl(shift: Int) = (this.toUInt() shl shift).toUByte()

operator fun UByteArray.get(index: UByte) = this[index.toInt()]

operator fun UByteArray.set(index: UByte, value: UByte) {
    this[index.toInt()] = value
}
