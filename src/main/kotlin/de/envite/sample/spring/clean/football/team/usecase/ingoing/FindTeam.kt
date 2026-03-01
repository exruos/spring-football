package de.envite.sample.spring.clean.football.team.usecase.ingoing

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamId

interface FindTeam {
    operator fun invoke(teamId: TeamId): Team?
}
