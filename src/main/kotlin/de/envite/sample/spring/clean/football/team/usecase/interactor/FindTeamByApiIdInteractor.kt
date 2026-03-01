package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeamByApiId
import org.springframework.stereotype.Component
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamByApiId as FindTeamByApiIdApi

@Component
internal class FindTeamByApiIdInteractor(
    private val readTeamByApiId: ReadTeamByApiId
) : FindTeamByApiIdApi {
    override fun invoke(teamApiId: TeamApiId) = readTeamByApiId(teamApiId)
}
