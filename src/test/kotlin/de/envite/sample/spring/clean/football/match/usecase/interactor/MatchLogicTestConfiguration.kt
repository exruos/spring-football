package de.envite.sample.spring.clean.football.match.usecase.interactor

import de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence.MatchPersistenceTestConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    MatchLogicConfiguration::class,
    MatchPersistenceTestConfiguration::class
)
@Configuration
@EnableAutoConfiguration
class MatchLogicTestConfiguration
