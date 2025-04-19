package de.envite.sample.spring.clean.football.types

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonValue
import de.envite.sample.spring.clean.football.types.validation.Validation
import de.envite.sample.spring.clean.football.types.validation.Validation.Companion.validate

typealias Constraints<T> = Validation<T>.() -> Unit

val NO_CONSTRAINTS: Constraints<*> = {}

/**
 * A _value type_ (a.k.a. _"domain primitive"_) wraps a given (primitive) value
 * and combines it with requirements that the _value_ has to meet.
 *
 * Other properties of a _value type_ include:
 *
 *  - Equality and hashcode are determined based on the wrapped value.
 *  - String representation (`toString()`) is delegated to the wrapped value and actual type of the instance.
 *  - Wrapped value is used when serializing instances to JSON.
 */
open class TypedValue<T : Any> protected constructor(
    @JsonIgnore val value: T, // see https://github.com/FasterXML/jackson-module-kotlin/issues/432 for reason
    constraints: Validation<T>.() -> Unit = NO_CONSTRAINTS
) {

    init {
        if (constraints != NO_CONSTRAINTS) {
            validate(value, javaClass.simpleName, constraints)
        }
    }

    override fun toString() = value.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        return value == (other as TypedValue<*>).value
    }

    override fun hashCode(): Int = value.hashCode()

    @JsonValue
    internal fun valueForSerializationAsJson(): T = value
}
