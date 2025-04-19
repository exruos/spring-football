package de.envite.sample.spring.clean.football.types

import de.envite.sample.spring.clean.football.types.validation.isBetween

open class TypedInt(value: Int, constraints: Constraints<Int> = NO_CONSTRAINTS) :
    TypedValue<Int>(value, constraints), Comparable<TypedInt> {

    override fun compareTo(other: TypedInt) = value.compareTo(other.value)
}

class PercentRange(override val endInclusive: Int, override val start: Int) : ClosedRange<Int>

@Suppress("MagicNumber")
class Percentage(value: Int) : TypedInt(value, {
    isBetween(PercentRange(100, 0))
})
