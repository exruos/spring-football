package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchCrudRepository : CrudRepository<MatchDto, Int> {
    fun findByHomeTeamApiIdOrAwayTeamApiId(homeTeamApiId: Int, awayTeamApiId: Int): List<MatchDto>
}
