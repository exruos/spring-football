package de.envite.sample.spring.clean.football.types.validation

open class ValidationException(label: String, val violations: List<String>) :
    IllegalArgumentException("Value of $label is invalid: ${violations.joinToString(separator = "; ")}")
