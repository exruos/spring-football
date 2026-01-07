package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.match.domain.MatchForResultTable
import de.envite.sample.spring.clean.football.match.usecase.outgoing.ReadMatchesForResultTable
import org.springframework.stereotype.Component

/**
 * Repository adapter that provides optimized match data for result table calculation.
 * Uses a lightweight query that excludes all player lineup data,
 * fetching only team IDs and goals from the database.
 */
@Component
class MatchForResultTableRepository(
    private val matchForResultTableCrudRepository: MatchForResultTableCrudRepository
) : ReadMatchesForResultTable {

    override fun invoke(season: String, leagueName: String): List<MatchForResultTable> {
        val matchDtos = matchForResultTableCrudRepository.findBySeasonAndLeagueNameForResultTable(season, leagueName)
        return matchDtos.map { it.toMatchForResultTable() }
    }
}
