package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    TeamRepository::class,
    TeamAttributesRepository::class
)
@Configuration
class TeamPersistenceConfiguration
