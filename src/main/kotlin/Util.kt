@file:OptIn(ExperimentalUnsignedTypes::class)

package de.haw.landshut

import kotlin.math.pow

infix fun UShort.mask(mask: Int) = this.and(mask.toUShort())

infix fun UByte.mask(mask: Int) = this.and(mask.toUByte())

infix fun UByte.combine(other: UByte): UShort {
    val leftBits: UShort = this.toUShort().shl(8)
    val rightBits: UShort = other.toUShort()
    return (leftBits + rightBits).toUShort()
}

fun UByte.bitAt(index: Int): Boolean = this.shr(index) and 1u == 1u.toUByte()

val UByte.rightNibble: UByte
    get() = this mask 0x0F

val UByte.leftNibble: UByte
    get() = this mask 0xF0 shr 4

val UShort.leftByte: UByte
    get() = (this.toUInt() shr 8).toUByte()

val UShort.rightByte: UByte
    get() = this.toUByte()

infix fun Int.pow(exponent: Int) = this.toDouble().pow(exponent).toInt()

infix fun UShort.shr(shift: Int) = (this.toUInt() shr shift).toUShort()

infix fun UShort.shl(shift: Int) = (this.toUInt() shl shift).toUShort()

infix fun UByte.shr(shift: Int) = (this.toUInt() shr shift).toUByte()

infix fun UByte.shl(shift: Int) = (this.toUInt() shl shift).toUByte()

operator fun UByteArray.get(index: UByte) = this[index.toInt()]

operator fun UByteArray.set(index: UByte, value: UByte) {
    this[index.toInt()] = value
}
