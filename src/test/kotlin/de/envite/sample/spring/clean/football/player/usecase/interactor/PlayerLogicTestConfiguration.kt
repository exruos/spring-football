package de.envite.sample.spring.clean.football.player.usecase.interactor

import de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence.PlayerPersistenceTestConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    PlayerLogicConfiguration::class,
    PlayerPersistenceTestConfiguration::class
)
@Configuration
class PlayerLogicTestConfiguration
