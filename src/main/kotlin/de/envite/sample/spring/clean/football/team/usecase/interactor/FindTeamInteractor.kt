package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeam
import org.springframework.stereotype.Component
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeam as FindTeamApi

@Component
internal class FindTeamInteractor(
    private val readTeam: ReadTeam
) : FindTeamApi {
    override fun invoke(teamId: TeamId) = readTeam(teamId)
}
