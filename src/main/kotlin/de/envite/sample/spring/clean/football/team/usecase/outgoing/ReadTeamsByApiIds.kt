package de.envite.sample.spring.clean.football.team.usecase.outgoing

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamApiId

interface ReadTeamsByApiIds {
    operator fun invoke(teamApiIds: List<TeamApiId>): List<Team>
}