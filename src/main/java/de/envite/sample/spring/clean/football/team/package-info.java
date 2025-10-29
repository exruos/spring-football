/**
 * Team module - manages team entities and related operations.
 * <p>
 * This module follows clean architecture principles with:
 * - Domain layer: Core team entities and business rules
 * - Use case layer: Team-specific business operations
 * - Adapter layer: Infrastructure concerns (persistence, REST API)
 * <p>
 * Exposed interfaces:
 * - Team domain model for other modules to reference
 * - Team use cases for cross-module operations
 */
@org.springframework.modulith.ApplicationModule(
    displayName = "Team Management",
    allowedDependencies = {"types"}
)
package de.envite.sample.spring.clean.football.team;