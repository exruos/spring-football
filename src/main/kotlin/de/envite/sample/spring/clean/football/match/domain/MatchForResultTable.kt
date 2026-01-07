package de.envite.sample.spring.clean.football.match.domain

/**
 * Lightweight match representation for result table calculation.
 * Contains only the data needed to calculate team statistics:
 * - Team IDs to identify which teams played
 * - Goals to calculate points, wins, draws, losses
 *
 * This avoids loading unnecessary player lineup data when calculating standings.
 */
data class MatchForResultTable(
    val homeTeamId: TeamId,
    val awayTeamId: TeamId,
    val homeTeamGoal: Goals?,
    val awayTeamGoal: Goals?
)
