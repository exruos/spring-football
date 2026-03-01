package de.envite.sample.spring.clean.football.match.usecase.interactor

import de.envite.sample.spring.clean.football.match.domain.TeamId
import de.envite.sample.spring.clean.football.match.usecase.outgoing.ReadMatchesByTeam
import org.springframework.stereotype.Component
import de.envite.sample.spring.clean.football.match.usecase.ingoing.FindMatchesByTeam as FindMatchesByTeamApi

@Component
internal class FindMatchesByTeamInteractor(
    private val readMatchesByTeam: ReadMatchesByTeam
) : FindMatchesByTeamApi {
    override fun invoke(teamId: TeamId) = readMatchesByTeam(teamId)
}
