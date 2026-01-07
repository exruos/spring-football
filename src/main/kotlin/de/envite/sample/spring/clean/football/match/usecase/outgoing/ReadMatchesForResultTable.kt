package de.envite.sample.spring.clean.football.match.usecase.outgoing

import de.envite.sample.spring.clean.football.match.domain.MatchForResultTable

/**
 * Port for reading match data optimized for result table calculation.
 * Returns only the essential match data (team IDs and goals) without player lineups.
 */
interface ReadMatchesForResultTable {
    operator fun invoke(season: String, leagueName: String): List<MatchForResultTable>
}
