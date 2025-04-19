package de.envite.sample.spring.clean.football.types

import java.time.LocalDate

open class TypedLocalDate protected constructor(value: LocalDate) :
    TypedValue<LocalDate>(value), Comparable<TypedLocalDate> {

    override fun compareTo(other: TypedLocalDate) = value.compareTo(other.value)
}
