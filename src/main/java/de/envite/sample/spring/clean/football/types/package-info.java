/**
 * Types module - shared type definitions and utilities.
 * <p>
 * This module contains:
 * - Base type classes (TypedInt, TypedValue)
 * - Common value objects used across modules
 * - Shared utility types
 * <p>
 * This is a foundational module that other modules can depend on
 * without creating circular dependencies.
 */
@org.springframework.modulith.ApplicationModule(
    displayName = "Shared Types",
    allowedDependencies = {}
)
package de.envite.sample.spring.clean.football.types;