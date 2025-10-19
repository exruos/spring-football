package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    FootballDbDataSourceConfiguration::class,
    PlayerRepository::class,
    PlayerAttributesRepository::class
)
@Configuration
class PlayerPersistenceConfiguration
