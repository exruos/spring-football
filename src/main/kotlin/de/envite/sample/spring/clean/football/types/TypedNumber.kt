package de.envite.sample.spring.clean.football.types

open class TypedNumber<T>(value: T, constraints: Constraints<T> = NO_CONSTRAINTS) :
    ComparableTypedValue<T>(value, constraints) where T : Number, T : Comparable<T>
