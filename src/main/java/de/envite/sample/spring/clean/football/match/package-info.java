/**
 * Match module - manages match entities and related operations.
 * <p>
 * This module follows clean architecture principles with:
 * - Domain layer: Core match entities and business rules
 * - Use case layer: Match-specific business operations
 * - Adapter layer: Infrastructure concerns (persistence, REST API)
 * <p>
 * Module Independence:
 * - Contains its own PlayerId and TeamId types for complete module independence
 * - No cross-module dependencies on other business modules (player, team)
 * - Only depends on shared foundational types
 * <p>
 * Exposed interfaces:
 * - Match domain model for other modules to reference
 * - Match use cases for cross-module operations
 */
@org.springframework.modulith.ApplicationModule(
    displayName = "Match Management",
    allowedDependencies = {"types"}
)
package de.envite.sample.spring.clean.football.match;