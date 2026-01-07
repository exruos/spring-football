package de.envite.sample.spring.clean.football.match.usecase.interactor

import de.envite.sample.spring.clean.football.match.domain.ResultTableRow
import de.envite.sample.spring.clean.football.match.domain.TeamId
import de.envite.sample.spring.clean.football.match.usecase.ingoing.GetResultTable
import de.envite.sample.spring.clean.football.match.usecase.outgoing.ReadMatchesForResultTable
import org.springframework.stereotype.Component

@Component
internal class GetResultTableInteractor(
    private val readMatchesForResultTable: ReadMatchesForResultTable
) : GetResultTable {

    override fun invoke(season: String, leagueName: String): List<ResultTableRow> {
        val matches = readMatchesForResultTable(season, leagueName)

        // Group statistics by team
        val teamStats = mutableMapOf<TeamId, TeamStatistics>()

        matches.forEach { match ->
            // Only process matches with goals recorded
            val homeGoals = match.homeTeamGoal?.value
            val awayGoals = match.awayTeamGoal?.value

            if (homeGoals != null && awayGoals != null) {
                // Update home team statistics
                val homeStats = teamStats.getOrPut(match.homeTeamId) { TeamStatistics() }
                homeStats.goalsScored += homeGoals
                homeStats.goalsConceded += awayGoals

                when {
                    homeGoals > awayGoals -> {
                        homeStats.wins++
                        homeStats.points += POINTS_FOR_WIN
                    }
                    homeGoals == awayGoals -> {
                        homeStats.draws++
                        homeStats.points += POINTS_FOR_DRAW
                    }
                    else -> {
                        homeStats.losses++
                    }
                }

                // Update away team statistics
                val awayStats = teamStats.getOrPut(match.awayTeamId) { TeamStatistics() }
                awayStats.goalsScored += awayGoals
                awayStats.goalsConceded += homeGoals

                when {
                    awayGoals > homeGoals -> {
                        awayStats.wins++
                        awayStats.points += POINTS_FOR_WIN
                    }
                    awayGoals == homeGoals -> {
                        awayStats.draws++
                        awayStats.points += POINTS_FOR_DRAW
                    }
                    else -> {
                        awayStats.losses++
                    }
                }
            }
        }

        // Convert to ResultTableRow and sort
        return teamStats.map { (teamId, stats) ->
            ResultTableRow(
                teamId = teamId,
                points = stats.points,
                wins = stats.wins,
                draws = stats.draws,
                losses = stats.losses,
                goalsScored = stats.goalsScored,
                goalsConceded = stats.goalsConceded
            )
        }.sortedWith(
            compareByDescending<ResultTableRow> { it.points }
                .thenByDescending { it.goalsScored - it.goalsConceded } // Goal difference
                .thenByDescending { it.goalsScored }
        )
    }

    private data class TeamStatistics(
        var points: Int = 0,
        var wins: Int = 0,
        var draws: Int = 0,
        var losses: Int = 0,
        var goalsScored: Int = 0,
        var goalsConceded: Int = 0
    )

    companion object {
        private const val POINTS_FOR_WIN = 3
        private const val POINTS_FOR_DRAW = 1
    }
}
