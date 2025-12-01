package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@Import(
    TeamRepository::class,
    TeamAttributesRepository::class
)
@Configuration
@EnableJdbcRepositories(
    basePackages = [
        "de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence"
    ]
)
class TeamPersistenceConfiguration
