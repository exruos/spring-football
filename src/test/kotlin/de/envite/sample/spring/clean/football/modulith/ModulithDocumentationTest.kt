package de.envite.sample.spring.clean.football.modulith

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

/**
 * Generates Spring Modulith documentation files including PlantUML diagrams
 * and AsciiDoc documentation for all modules.
 *
 * This test creates comprehensive architectural documentation that includes:
 * - Module dependency diagrams
 * - Individual module documentation
 * - Overall system architecture visualization
 */
class ModulithDocumentationTest {

    @Test
    fun `should create module documentation`() {
        val modules = ApplicationModules.of("de.envite.sample.spring.clean.football")

        System.err.println("📝 Generating Spring Modulith documentation files...")
        System.err.println("   • Module documentation (AsciiDoc)")
        System.err.println("   • Individual module PlantUML diagrams")
        System.err.println("   • Module dependency graphs")
        System.err.println("   • Overall system architecture diagram")

        Documenter(modules)
            .writeDocumentation()
            .writeIndividualModulesAsPlantUml()

        System.err.println("✅ Documentation files generated successfully!")
        System.err.println("   📁 Location: build/spring-modulith-docs/")
        System.err.println("   📋 Files generated:")
        System.err.println("      • all-docs.adoc - Complete documentation")
        System.err.println("      • components.puml - System architecture diagram")
        System.err.println("      • module-*.adoc - Individual module docs")
        System.err.println("      • module-*.puml - Individual module diagrams")
    }

    @Test
    fun `should document modulith architecture and configuration`() {
        val modules = ApplicationModules.of("de.envite.sample.spring.clean.football")

        System.err.println("╔═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║                           SPRING MODULITH DOCUMENTATION                              ║")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║")
        System.err.println("║ 🏗️  ARCHITECTURE: Clean Architecture with Domain-Driven Design")
        System.err.println("║ 🎯  GOAL: Complete module independence - no cross-module dependencies")
        System.err.println("║ 📦  MODULES: Each business domain is a separate, independent module")
        System.err.println("║")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║                                    DISCOVERED MODULES")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")

        modules.forEach { module ->
            System.err.println("║")
            System.err.println("║ 📦 MODULE: ${module.displayName}")
            System.err.println("║    Package: ${module.basePackage}")
            System.err.println("║    Components: ${module.springBeans.size} Spring beans")

            // Document the module structure based on its type
            when {
                module.basePackage.contains(".types") -> {
                    System.err.println("║    Type: 🔧 SHARED FOUNDATION MODULE")
                    System.err.println("║    Purpose: Provides common types, utilities, and foundational classes")
                    System.err.println("║    Dependencies: None (foundation layer)")
                    System.err.println("║    Usage: Can be used by all other modules")
                }
                module.basePackage.contains(".match") -> {
                    System.err.println("║    Type: 🏟️  BUSINESS DOMAIN MODULE (Match Management)")
                    System.err.println("║    Purpose: Manages football matches, scores, and match-related operations")
                    System.err.println("║    Architecture: Domain → UseCase → Adapter (Clean Architecture)")
                    System.err.println("║    Independence: Contains local TeamId, PlayerId, Day types")
                    System.err.println("║    Dependencies: Only 'types' module")
                    System.err.println(
                        "║    Key Feature: No cross-module dependencies achieved via local type definitions"
                    )
                }
                module.basePackage.contains(".team") -> {
                    System.err.println("║    Type: ⚽ BUSINESS DOMAIN MODULE (Team Management)")
                    System.err.println("║    Purpose: Manages football teams, team information, and team operations")
                    System.err.println("║    Architecture: Domain → UseCase → Adapter (Clean Architecture)")
                    System.err.println("║    Dependencies: Only 'types' module")
                }
                module.basePackage.contains(".player") -> {
                    System.err.println("║    Type: 👤 BUSINESS DOMAIN MODULE (Player Management)")
                    System.err.println(
                        "║    Purpose: Manages football players, player information, and player operations"
                    )
                    System.err.println("║    Architecture: Domain → UseCase → Adapter (Clean Architecture)")
                    System.err.println("║    Dependencies: Only 'types' module")
                }
                else -> {
                    System.err.println("║    Type: ❓ OTHER MODULE")
                    System.err.println("║    Purpose: Additional functionality")
                }
            }
        }

        System.err.println("║")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║                               MODULE INDEPENDENCE STRATEGY")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║")
        System.err.println(
            "║ 🎯 PROBLEM: Modules need to reference entities from other modules (e.g., Match needs Team)"
        )
        System.err.println("║")
        System.err.println("║ ❌ BAD APPROACH: Import TeamId from team module → creates dependency")
        System.err.println("║    // DON'T DO THIS:")
        System.err.println("║    import de.envite.sample.spring.clean.football.team.domain.TeamId")
        System.err.println("║")
        System.err.println("║ ✅ SOLUTION: Local type definitions in each module")
        System.err.println("║    // IN MATCH MODULE:")
        System.err.println("║    class TeamId(value: Int) : TypedInt(value) { ... }")
        System.err.println("║    class PlayerId(value: Int) : TypedInt(value) { ... }")
        System.err.println("║")
        System.err.println("║ 📍 IMPLEMENTATION:")
        System.err.println("║    • Each module defines its own ID types for external entities")
        System.err.println("║    • Types inherit from shared foundation classes (TypedInt, TypedValue)")
        System.err.println("║    • Modules remain completely independent")
        System.err.println("║    • Cross-module communication happens at API boundaries, not code level")
        System.err.println("║")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║                                SPRING MODULITH CONFIGURATION")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║")
        System.err.println("║ 📁 Configuration Files:")
        System.err.println("║    • src/main/java/.../match/package-info.java")
        System.err.println("║    • src/main/java/.../team/package-info.java")
        System.err.println("║    • src/main/java/.../player/package-info.java")
        System.err.println("║")
        System.err.println("║ 📝 @ApplicationModule Annotation:")
        System.err.println("║    @ApplicationModule(")
        System.err.println("║        displayName = \"Module Name\",")
        System.err.println("║        allowedDependencies = {\"types\"}  // Only shared types allowed")
        System.err.println("║    )")
        System.err.println("║")
        System.err.println("║ ⚠️  IMPORTANT: Spring Modulith's verify() method:")
        System.err.println("║    • Validates ACTUAL code dependencies (imports)")
        System.err.println("║    • Does NOT validate @ApplicationModule allowedDependencies declarations")
        System.err.println("║    • Real independence achieved through code structure, not annotations")
        System.err.println("║")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║                                      USAGE GUIDE")
        System.err.println("╠═══════════════════════════════════════════════════════════════════════════════════════")
        System.err.println("║")
        System.err.println("║ 🔧 To add a new module:")
        System.err.println("║    1. Create package structure: domain → usecase → adapter")
        System.err.println("║    2. Add package-info.java with @ApplicationModule annotation")
        System.err.println("║    3. Define local types for external entity references")
        System.err.println("║    4. Only depend on 'types' module")
        System.err.println("║    5. Run boundary verification tests to validate independence")
        System.err.println("║")
        System.err.println("║ 📋 To validate module boundaries:")
        System.err.println("║    ./gradlew test --tests \"*BoundaryVerificationTest*\"")
        System.err.println("║")
        System.err.println("║ 📋 To generate documentation:")
        System.err.println("║    ./gradlew test --tests \"*ModulithDocumentationTest*\"")
        System.err.println("║")
        System.err.println("║ 🎯 Key Success Metrics:")
        System.err.println("║    • Zero cross-module imports in business modules")
        System.err.println("║    • Each module can be built/tested independently")
        System.err.println("║    • Clear API boundaries between modules")
        System.err.println("║    • Spring Modulith verification passes")
        System.err.println("║")
        System.err.println("╚═══════════════════════════════════════════════════════════════════════════════════════")

        // Verify we have the expected module structure
        val moduleNames = modules.map { it.displayName }.toSet()
        assert(moduleNames.any { it.contains("Match", true) }) { "Match module missing" }
        assert(moduleNames.any { it.contains("Team", true) }) { "Team module missing" }
        assert(moduleNames.any { it.contains("Player", true) }) { "Player module missing" }
        assert(moduleNames.any { it.contains("Types", true) }) { "Types module missing" }

        System.err.println()
        System.err.println("✅ MODULITH DOCUMENTATION COMPLETE - All modules validated and documented!")
    }
}
