package de.envite.sample.spring.clean.football.match.usecase.interactor

import de.envite.sample.spring.clean.football.match.domain.MatchId
import de.envite.sample.spring.clean.football.match.usecase.outgoing.ReadMatch
import org.springframework.stereotype.Component
import de.envite.sample.spring.clean.football.match.usecase.ingoing.FindMatch as FindMatchApi

@Component
internal class FindMatchInteractor(
    private val readMatch: ReadMatch
) : FindMatchApi {
    override fun invoke(matchId: MatchId) = readMatch(matchId)
}
