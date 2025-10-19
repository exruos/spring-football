package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence.FootballDbDataSourceConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    FootballDbDataSourceConfiguration::class,
    TeamRepository::class,
    TeamAttributesRepository::class
)
@Configuration
class TeamPersistenceConfiguration
