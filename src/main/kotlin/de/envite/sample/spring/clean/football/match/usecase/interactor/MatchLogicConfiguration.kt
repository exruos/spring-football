package de.envite.sample.spring.clean.football.match.usecase.interactor

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    FindMatchInteractor::class,
    FindMatchesByTeamInteractor::class
)
@Configuration
class MatchLogicConfiguration
