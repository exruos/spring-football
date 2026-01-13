package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeam
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeamByApiId
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeamsByApiIds
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class TeamRepository(
    val teamCrudRepository: TeamCrudRepository
) : ReadTeam, ReadTeamByApiId, ReadTeamsByApiIds {

    override fun invoke(teamId: TeamId): Team? {
        val teamDto = teamCrudRepository.findById(teamId.value)
        return teamDto.getOrNull()?.toTeam()
    }

    override fun invoke(teamApiId: TeamApiId): Team? {
        val teamDto = teamCrudRepository.findByTeamApiId(teamApiId.value)
        return teamDto?.toTeam()
    }

    override fun invoke(teamApiIds: List<TeamApiId>): List<Team> {
        val apiIdValues = teamApiIds.map { it.value }
        val teamDtos = teamCrudRepository.findByTeamApiIdIn(apiIdValues)
        return teamDtos.map { it.toTeam() }
    }
}
