package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.domain.MatchId
import de.envite.sample.spring.clean.football.match.usecase.outgoing.ReadMatch
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class MatchRepository(
    val matchCrudRepository: MatchCrudRepository
) : ReadMatch {

    override fun invoke(matchId: MatchId): Match? {
        val matchDto = matchCrudRepository.findById(matchId.value)
        return matchDto.getOrNull()?.toMatch()
    }
}
