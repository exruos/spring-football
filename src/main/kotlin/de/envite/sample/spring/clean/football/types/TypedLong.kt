package de.envite.sample.spring.clean.football.types

open class TypedLong protected constructor(value: Long) :
    TypedValue<Long>(value), Comparable<TypedLong> {

    override fun compareTo(other: TypedLong) = value.compareTo(other.value)
}
