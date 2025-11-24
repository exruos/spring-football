package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchCrudRepository : CrudRepository<MatchDto, Int> {
    fun findByHomeTeamApiIdOrAwayTeamApiId(homeTeamApiId: Int, awayTeamApiId: Int): List<MatchDto>

    @Query(
        """
        SELECT m.* FROM match m
        JOIN league l ON m.league_id = l.id
        WHERE m.season = :season AND l.name = :leagueName
        """
    )
    fun findBySeasonAndLeagueName(season: String, leagueName: String): List<MatchDto>
}
