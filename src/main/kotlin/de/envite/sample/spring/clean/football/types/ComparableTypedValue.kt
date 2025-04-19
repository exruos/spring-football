package de.envite.sample.spring.clean.football.types

/**
 * A [TypedValue] where the values are comparable.
 */
open class ComparableTypedValue<T : Comparable<T>>(value: T, constraints: Constraints<T> = NO_CONSTRAINTS) :
    TypedValue<T>(value, constraints), Comparable<ComparableTypedValue<T>> {
    override fun compareTo(other: ComparableTypedValue<T>): Int = value.compareTo(other.value)
}
