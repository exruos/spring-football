package de.envite.sample.spring.clean.football.team

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
    displayName = "Team",
    allowedDependencies = ["types"]
)
class ModuleMetadata
