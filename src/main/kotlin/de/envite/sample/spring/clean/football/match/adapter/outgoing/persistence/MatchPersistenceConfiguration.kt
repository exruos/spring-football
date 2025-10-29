package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@Configuration
@EnableJdbcRepositories(
    basePackages = [
        "de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence"
    ]
)
@Import(
    MatchRepository::class,
    MatchByTeamRepository::class
)
class MatchPersistenceConfiguration
