package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeamsByApiIds
import org.springframework.stereotype.Component
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamsByApiIds as FindTeamsByApiIdsApi

@Component
internal class FindTeamsByApiIdsInteractor(
    private val readTeamsByApiIds: ReadTeamsByApiIds
) : FindTeamsByApiIdsApi {
    override fun invoke(teamApiIds: List<TeamApiId>) = readTeamsByApiIds(teamApiIds)
}
