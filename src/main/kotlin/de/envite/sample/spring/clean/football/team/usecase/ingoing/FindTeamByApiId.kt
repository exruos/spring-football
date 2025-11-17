package de.envite.sample.spring.clean.football.team.usecase.ingoing

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamApiId

interface FindTeamByApiId {
    operator fun invoke(teamApiId: TeamApiId): Team?
}
