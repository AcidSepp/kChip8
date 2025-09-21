package de.haw.landshut

infix fun UByte.combine(other: UByte): UShort {
    val leftBits: UShort = this.toUShort().shl(8)
    val rightBits: UShort = other.toUShort()
    return (leftBits + rightBits).toUShort()
}

fun UByte.bitAt(index: Int): Boolean = this.shr(index) and 1u == 1u.toUByte()