package de.envite.sample.spring.clean.football.types

import java.util.*

open class TypedUUID protected constructor(value: UUID) :
    TypedValue<UUID>(value), Comparable<TypedUUID> {

    override fun compareTo(other: TypedUUID) = value.compareTo(other.value)
}
