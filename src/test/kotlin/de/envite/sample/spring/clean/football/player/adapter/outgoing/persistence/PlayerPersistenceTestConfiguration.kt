package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.TestcontainersConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    PlayerPersistenceConfiguration::class,
    TestcontainersConfiguration::class
)
@Configuration
@EnableAutoConfiguration
class PlayerPersistenceTestConfiguration
