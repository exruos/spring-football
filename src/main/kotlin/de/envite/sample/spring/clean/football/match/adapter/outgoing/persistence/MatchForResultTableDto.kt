package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

/**
 * Lightweight DTO for result table calculation.
 * Only contains the essential fields needed for calculating team statistics.
 * Excludes all player lineup data to optimize database queries.
 */
@Table("match")
data class MatchForResultTableDto(
    @Id val id: Int,
    @Column("home_team_api_id") val homeTeamApiId: Int?,
    @Column("away_team_api_id") val awayTeamApiId: Int?,
    @Column("home_team_goal") val homeTeamGoal: Int?,
    @Column("away_team_goal") val awayTeamGoal: Int?
)
