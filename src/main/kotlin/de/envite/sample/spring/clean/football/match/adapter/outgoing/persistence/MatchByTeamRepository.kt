package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.domain.TeamId
import de.envite.sample.spring.clean.football.match.usecase.outgoing.ReadMatchesByTeam
import org.springframework.stereotype.Component

@Component
class MatchByTeamRepository(
    val matchCrudRepository: MatchCrudRepository
) : ReadMatchesByTeam {

    override fun invoke(teamId: TeamId): List<Match> {
        // Note: This assumes TeamId.value corresponds to team_api_id in match table
        // You might need to adjust this mapping based on your actual team ID structure
        val matchDtos = matchCrudRepository.findByHomeTeamApiIdOrAwayTeamApiId(teamId.value, teamId.value)
        return matchDtos.map { it.toMatch() }
    }
}
