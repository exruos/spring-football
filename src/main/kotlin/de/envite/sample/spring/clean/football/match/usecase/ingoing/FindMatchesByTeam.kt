package de.envite.sample.spring.clean.football.match.usecase.ingoing

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.team.domain.TeamId

interface FindMatchesByTeam {
    operator fun invoke(teamId: TeamId): List<Match>
}
