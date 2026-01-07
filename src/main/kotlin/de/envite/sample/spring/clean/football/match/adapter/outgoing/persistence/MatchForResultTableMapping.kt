package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.match.domain.Goals
import de.envite.sample.spring.clean.football.match.domain.MatchForResultTable
import de.envite.sample.spring.clean.football.match.domain.TeamId

/**
 * Converts the lightweight DTO to the domain model for result table calculation.
 */
fun MatchForResultTableDto.toMatchForResultTable(): MatchForResultTable {
    return MatchForResultTable(
        homeTeamId = TeamId(homeTeamApiId ?: 0),
        awayTeamId = TeamId(awayTeamApiId ?: 0),
        homeTeamGoal = homeTeamGoal?.let { Goals(it) },
        awayTeamGoal = awayTeamGoal?.let { Goals(it) }
    )
}
