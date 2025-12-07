package de.envite.sample.spring.clean.football.match

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
    displayName = "Match",
    allowedDependencies = ["types", "team"]  // Temporarily allow full team module due to cross-platform NamedInterface loading issue
)
class ModuleMetadata
