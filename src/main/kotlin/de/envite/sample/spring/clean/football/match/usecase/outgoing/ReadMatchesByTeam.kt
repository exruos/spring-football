package de.envite.sample.spring.clean.football.match.usecase.outgoing

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.team.domain.TeamId

interface ReadMatchesByTeam {
    operator fun invoke(teamId: TeamId): List<Match>
}
