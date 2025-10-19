package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeam
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class TeamRepository(
    val teamCrudRepository: TeamCrudRepository
) : ReadTeam {

    override fun invoke(teamId: TeamId): Team? {
        val teamDto = teamCrudRepository.findById(teamId.value)
        return teamDto.getOrNull()?.toTeam()
    }
}
