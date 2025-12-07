package de.envite.sample.spring.clean.football.match

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
    displayName = "Match",
    allowedDependencies = ["types", "team :: pojo-api"]
)
class ModuleMetadata
