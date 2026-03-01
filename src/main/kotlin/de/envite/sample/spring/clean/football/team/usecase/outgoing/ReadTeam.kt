package de.envite.sample.spring.clean.football.team.usecase.outgoing

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamId

interface ReadTeam {
    operator fun invoke(teamId: TeamId): Team?
}
