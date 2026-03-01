package de.envite.sample.spring.clean.football.team.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.team.usecase.interactor.TeamLogicConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    TeamLogicConfiguration::class,
    TeamRestController::class,
    EntityToRestResourceMapper::class
)
@Configuration
class TeamRestModuleConfiguration
