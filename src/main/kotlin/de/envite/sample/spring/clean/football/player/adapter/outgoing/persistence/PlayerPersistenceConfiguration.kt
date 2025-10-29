package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@Configuration
@EnableJdbcRepositories(
    basePackages = [
        "de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence"
    ]
)
class PlayerPersistenceConfiguration
