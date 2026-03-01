package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    MatchRepository::class,
    MatchByTeamRepository::class,
    MatchBySeasonAndLeagueRepository::class
)
class MatchPersistenceConfiguration
