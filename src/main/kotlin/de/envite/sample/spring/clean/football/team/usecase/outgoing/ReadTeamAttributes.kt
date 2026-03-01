package de.envite.sample.spring.clean.football.team.usecase.outgoing

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.domain.TeamAttributes
import de.envite.sample.spring.clean.football.team.domain.TeamFifaApiId

interface ReadTeamAttributes {
    operator fun invoke(teamFifaApiId: TeamFifaApiId, teamApiId: TeamApiId): List<TeamAttributes>
}
