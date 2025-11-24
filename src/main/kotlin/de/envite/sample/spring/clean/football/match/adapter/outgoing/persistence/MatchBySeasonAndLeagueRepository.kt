package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.usecase.outgoing.ReadMatchesBySeasonAndLeague
import org.springframework.stereotype.Component

@Component
class MatchBySeasonAndLeagueRepository(
    val matchCrudRepository: MatchCrudRepository
) : ReadMatchesBySeasonAndLeague {

    override fun invoke(season: String, leagueName: String): List<Match> {
        val matchDtos = matchCrudRepository.findBySeasonAndLeagueName(season, leagueName)
        return matchDtos.map { it.toMatch() }
    }
}
