/**
 * Player module - manages player entities and related operations.
 * <p>
 * This module follows clean architecture principles with:
 * - Domain layer: Core player entities and business rules
 * - Use case layer: Player-specific business operations
 * - Adapter layer: Infrastructure concerns (persistence, REST API, gRPC)
 * <p>
 * Exposed interfaces:
 * - Player domain model for other modules to reference
 * - Player use cases for cross-module operations
 */
@org.springframework.modulith.ApplicationModule(
    displayName = "Player Management",
    allowedDependencies = {"types", "proto"}
)
package de.envite.sample.spring.clean.football.player;