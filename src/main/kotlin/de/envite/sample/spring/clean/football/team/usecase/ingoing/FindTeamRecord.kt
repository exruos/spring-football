package de.envite.sample.spring.clean.football.team.usecase.ingoing

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamRecord

interface FindTeamRecord {
    operator fun invoke(teamId: TeamId): TeamRecord?
}
