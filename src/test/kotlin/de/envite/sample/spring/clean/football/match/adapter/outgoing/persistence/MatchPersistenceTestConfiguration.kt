package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    MatchPersistenceConfiguration::class
)
@Configuration
@EnableAutoConfiguration
class MatchPersistenceTestConfiguration
