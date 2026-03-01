package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence.TeamPersistenceTestConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    TeamLogicConfiguration::class,
    TeamPersistenceTestConfiguration::class
)
@Configuration
@EnableAutoConfiguration
class TeamLogicTestConfiguration
