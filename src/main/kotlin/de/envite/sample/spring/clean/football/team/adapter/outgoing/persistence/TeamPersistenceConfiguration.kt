package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@Configuration
@EnableJdbcRepositories(
    basePackages = [
        "de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence"
    ]
)
class TeamPersistenceConfiguration
