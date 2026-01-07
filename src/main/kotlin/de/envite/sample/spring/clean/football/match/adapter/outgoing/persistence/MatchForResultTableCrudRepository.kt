package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Optimized repository for result table queries.
 * Uses a specialized DTO that excludes all player lineup data,
 * reducing the amount of data transferred from the database.
 */
@Repository
interface MatchForResultTableCrudRepository : CrudRepository<MatchForResultTableDto, Int> {

    @Query(
        """
        SELECT
            m.id,
            m.home_team_api_id,
            m.away_team_api_id,
            m.home_team_goal,
            m.away_team_goal
        FROM match m
        JOIN league l ON m.league_id = l.id
        WHERE m.season = :season AND l.name = :leagueName
        """
    )
    fun findBySeasonAndLeagueNameForResultTable(season: String, leagueName: String): List<MatchForResultTableDto>
}
