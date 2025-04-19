package de.envite.sample.spring.clean.football.player.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.player.usecase.interactor.PlayerLogicConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    PlayerLogicConfiguration::class,
    PlayerRestController::class,
    EntityToRestResourceMapper::class
)
@Configuration
class PlayerRestModuleConfiguration
