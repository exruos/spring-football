package de.envite.sample.spring.clean.football.team.usecase.interactor

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    FindTeamInteractor::class,
    FindTeamRecordInteractor::class
)
@Configuration
class TeamLogicConfiguration
