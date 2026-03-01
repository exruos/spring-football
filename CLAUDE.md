# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot football management service implementing **Clean Architecture with Domain-Driven Design** and **Spring Modulith** for strict module boundaries. The service provides both REST and gRPC endpoints for player, team, and match management.

## Key Commands

### Build and Test
```bash
# Build the entire project
./gradlew build

# Run all tests
./gradlew test

# Run a specific test class
./gradlew test --tests "ClassName"

# Run module boundary validation (fast, for CI/CD)
./gradlew test --tests "*BoundaryVerificationTest*"

# Generate Spring Modulith documentation (slower, occasional)
./gradlew test --tests "*ModulithDocumentationTest*"
```

### Local Development
```bash
# Run with Docker Compose
docker compose -f docker/compose.yml up

# Run with Podman Compose
podman-compose -f docker/compose.yml up
```

### API Testing
```bash
# REST endpoints
curl localhost:8088/players/1
curl localhost:8088/players/record/1

# gRPC endpoints
grpcurl -d '{"id":1}' -plaintext localhost:8088 Player.GetPlayerById
grpcurl -d '{"id":1}' -plaintext localhost:8088 Player.GetPlayerRecordById
```

## Architecture

### Module Independence Strategy

**Critical Pattern**: Each business module achieves complete independence through **local type definitions**. This is the core architectural principle that must be preserved.

```kotlin
// ❌ NEVER DO THIS - Creates cross-module dependency
import de.envite.sample.spring.clean.football.team.domain.TeamId

// ✅ CORRECT - Local type definition in match module
class TeamId(value: Int) : TypedInt(value) {
    companion object {
        fun fromString(v: String) = v.toInt().let(::TeamId)
    }
}
```

### Module Structure

**Business Modules** (completely independent):
- **match** - Match management with local `TeamId`, `PlayerId`, `Day` types
- **team** - Team management
- **player** - Player management

**Shared Modules**:
- **types** - Foundation classes (`TypedInt`, `TypedValue`, etc.)
- **proto** - Protocol Buffer definitions

### Clean Architecture Layers
Each business module follows: `domain` → `usecase` → `adapter`

### Spring Modulith Configuration
Modules are defined with `@ApplicationModule` in `package-info.java` files:
```java
@ApplicationModule(
    displayName = "Module Name",
    allowedDependencies = {"types"}  // Only shared types allowed
)
```

## Critical Development Rules

### Module Independence
1. **Never import between business modules** (match ↔ team ↔ player)
2. **Only depend on `types` module** for foundational classes
3. **Define local types** for external entity references
4. **Validate boundaries** with `BoundaryVerificationTest` before committing

### Testing Strategy
- **BoundaryVerificationTest** - Fast validation for module independence (run frequently)
- **ModulithDocumentationTest** - Generates comprehensive architecture documentation (run when architecture changes)

### Spring Modulith Validation
- `modules.verify()` only checks **actual code dependencies**, not `@ApplicationModule` declarations
- Real independence comes from code structure, not annotations
- Documentation is generated in `build/spring-modulith-docs/`

## Key Files and Locations

### Module Definitions
- `src/main/java/**/package-info.java` - Spring Modulith module configurations
- `src/main/kotlin/**/domain/` - Domain models with local type definitions

### Tests
- `src/test/kotlin/de/envite/sample/spring/clean/football/modulith/BoundaryVerificationTest.kt`
- `src/test/kotlin/de/envite/sample/spring/clean/football/modulith/ModulithDocumentationTest.kt`

### Configuration
- `build.gradle.kts` - Gradle configuration with Spring Modulith dependencies
- `docker/compose.yml` - Local development environment

## Technology Stack

- **Language**: Kotlin (Java 21)
- **Framework**: Spring Boot 3.5.6 with Spring Modulith 1.4.4
- **Database**: PostgreSQL with Flyway migrations
- **Build**: Gradle with Kotlin DSL
- **Protocols**: REST + gRPC endpoints
- **Architecture**: Clean Architecture + Domain-Driven Design
- **Quality**: Detekt for linting