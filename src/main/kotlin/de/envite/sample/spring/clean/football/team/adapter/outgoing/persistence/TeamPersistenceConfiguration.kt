package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence.PlayerDbDataSourceConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    PlayerDbDataSourceConfiguration::class,
    TeamRepository::class,
    TeamAttributesRepository::class
)
@Configuration
class TeamPersistenceConfiguration
