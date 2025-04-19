package de.envite.sample.spring.clean.football.types.validation

import java.math.BigDecimal

// COMPARABLE NUMBERS

/**
 * Requires that the _value_ is within the given range of integers including
 * the start and end values.
 */
fun <T> Validation<T>.isBetween(range: ClosedRange<T>) where T : Number, T : Comparable<T> =
    constraint(range.contains(value)) { "must be between ${range.start} and ${range.endInclusive}!" }

/**
 * Requires that the _value_ is greater than or equal to the given _min_ value.
 */
fun <T> Validation<T>.isGreaterThanOrEqualTo(minValue: T) where T : Number, T : Comparable<T> =
    constraint(value >= minValue) { "must be greater than or equal to $minValue!" }

/**
 * Requires that the _value_ is less than or equal to the given _max_ value.
 */
fun <T> Validation<T>.isLessThanOrEqualTo(maxValue: T) where T : Number, T : Comparable<T> =
    constraint(value <= maxValue) { "must be less than or equal to $maxValue!" }

// BIG DECIMAL

/**
 * Requires that the _value_ has a maximum of _maxDecimals_ decimals.
 */
fun Validation<BigDecimal>.hasMaxDecimals(maxDecimals: Int) =
    constraint(value.scale() <= maxDecimals) { "must not have more than $maxDecimals decimals!" }

// STRING

/**
 * Requires that the _value_ is not blank (not empty and not just whitespace
 * characters).
 */
fun Validation<String>.isNotBlank() =
    constraint(value.isNotBlank()) { "must not be blank!" }

/**
 * Requires that the _value_ matches the given regular expression.
 */
fun Validation<String>.matchesPattern(pattern: Regex) =
    constraint(value.matches(pattern)) { "must match pattern: $pattern" }

const val DEFAULT_MAX_LENGTH = 255

/**
 * Requires that the _value's_ length is not greater than the given _max_ length.
 */
fun Validation<String>.hasMaxLength(maxLength: Int = DEFAULT_MAX_LENGTH) =
    constraint(value.length <= maxLength) {
        "must not be longer than $maxLength characters, but is ${value.length} characters long!"
    }

/**
 * Requires that the _value's_ length is not greater than the given _max_ length.
 */
fun Validation<String>.hasLength(length: Int) =
    constraint(value.length == length) {
        "must be exactly $length characters long, but is ${value.length} characters long!"
    }

/**
 * Requires that the _value_ does not contain any of the given _characters_.
 * This is basically a character blacklist.
 */
fun Validation<String>.doesNotContainAny(characters: Iterable<Char>) =
    constraint(value.none { char -> characters.contains(char) }) {
        "contains at least one of the following illegal characters: ${characters.joinToString(" ")}"
    }

/*
 * The injection characters desrcibe the set of characters that are typically denoted as unsafe in a pen test.
 * After negotiation with our former PSO Tobias Dula, we stripped the set down to the following characters.
 * If necessary in the near future, it is possible to include other characters as well, like
 * '\'', '\b', '\n', '\r', '\t', '\\', '_', '/', '±', '§', '`', '~', ',', '@', '^', '*', '=', '!', '§', '$', '%',
 * '&', '(', ')', '[', ']', '{', '}', '?'
 */
val INJECTION_CHARACTERS = setOf(
    '<', '>', '"', '|', ';', '$', '{', '\'', '\\', '*', '}'
)
