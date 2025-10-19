package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.domain.TeamAttributes
import de.envite.sample.spring.clean.football.team.domain.TeamFifaApiId
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeamAttributes
import org.springframework.stereotype.Component

@Component
class TeamAttributesRepository(
    val teamCrudRepository: TeamCrudRepository
) : ReadTeamAttributes {

    override fun invoke(teamFifaApiId: TeamFifaApiId, teamApiId: TeamApiId): List<TeamAttributes> {
        val attributes = teamCrudRepository.getTeamAttributes(teamFifaApiId.value, teamApiId.value)
        return attributes.map { it.toTeamAttributes() }.toList()
    }
}
