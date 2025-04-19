package de.envite.sample.spring.clean.football.types

import de.envite.sample.spring.clean.football.types.validation.doesNotContainAny
import de.envite.sample.spring.clean.football.types.validation.hasLength
import de.envite.sample.spring.clean.football.types.validation.hasMaxLength
import de.envite.sample.spring.clean.football.types.validation.isNotBlank
import de.envite.sample.spring.clean.football.types.validation.matchesPattern

/**
 * [TypedValue] for [String] values.
 *
 * Since a _string_ could be basically anything it is highly recommended defining custom
 * requirements to further limit what kinds of values are actually valid.
 *
 * [TypedString] also implements [Comparable] based on the natural order of [String].
 */
open class TypedString(value: String, constraints: Constraints<String> = NO_CONSTRAINTS) :
    ComparableTypedValue<String>(value, constraints), CharSequence by value

/**
 * [TypedString] for a regex checked value.
 */
@Suppress("UNUSED")
open class RegexCheckedString(value: String, regex: Regex) : TypedString(value, { matchesPattern(regex) })

/**
 * [TypedString] for a non blank value.
 */
@Suppress("UNUSED")
open class NonBlankString(value: String) : TypedString(value, { isNotBlank() })

/**
 * [TypedString] for a value with a fixed size.
 */
@Suppress("UNUSED")
open class FixedSizeString(value: String, size: Int) : TypedString(value, { hasLength(size) })

/**
 * [TypedString] with a value with a fixed size does not consist of a certain character set.
 */
@Suppress("UNUSED")
open class SafeString(value: String, maxLength: Int) :
    TypedString(value, {
        hasMaxLength(maxLength)
        doesNotContainAny(de.envite.sample.spring.clean.football.types.validation.INJECTION_CHARACTERS)
    })
