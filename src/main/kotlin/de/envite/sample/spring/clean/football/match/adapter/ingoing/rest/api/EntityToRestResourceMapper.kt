package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.domain.PlayerLineup
import de.envite.sample.spring.clean.football.match.domain.ResultTableRow
import org.springframework.stereotype.Component

@Component
class EntityToRestResourceMapper(
    private val teamNameResolver: TeamNameResolver,
    private val properties: TeamNameResolverProperties
) {

    fun toMatchResource(match: Match): MatchResource {
        return MatchResource(
            matchId = match.matchId.value,
            countryId = match.countryId.value,
            leagueId = match.leagueId.value,
            season = match.season.value,
            stage = match.stage.value,
            date = match.date.toString(),
            matchApiId = match.matchApiId.value,
            homeTeamId = match.homeTeamId.value,
            awayTeamId = match.awayTeamId.value,
            homeTeamName = teamNameResolver.resolveTeamName(match.homeTeamId),
            awayTeamName = teamNameResolver.resolveTeamName(match.awayTeamId),
            homeTeamGoal = match.homeTeamGoal?.value,
            awayTeamGoal = match.awayTeamGoal?.value,
            homePlayerLineup = toPlayerLineupResource(match.homePlayerLineup),
            awayPlayerLineup = toPlayerLineupResource(match.awayPlayerLineup)
        )
    }

    private fun toPlayerLineupResource(lineup: PlayerLineup): PlayerLineupResource {
        return PlayerLineupResource(
            player1 = lineup.player1?.value,
            player2 = lineup.player2?.value,
            player3 = lineup.player3?.value,
            player4 = lineup.player4?.value,
            player5 = lineup.player5?.value,
            player6 = lineup.player6?.value,
            player7 = lineup.player7?.value,
            player8 = lineup.player8?.value,
            player9 = lineup.player9?.value,
            player10 = lineup.player10?.value,
            player11 = lineup.player11?.value
        )
    }

    fun toResultTableRowResource(row: ResultTableRow): ResultTableRowResource {
        return ResultTableRowResource(
            teamId = row.teamId.value,
            teamName = teamNameResolver.resolveTeamName(row.teamId),
            points = row.points,
            wins = row.wins,
            draws = row.draws,
            losses = row.losses,
            goalsScored = row.goalsScored,
            goalsConceded = row.goalsConceded
        )
    }

    /**
     * Batch conversion of result table rows to resources.
     * Uses batch fetching when configured with POJO_BATCH_WITH_CACHE strategy,
     * otherwise falls back to individual fetching.
     */
    fun toResultTableRowResources(rows: List<ResultTableRow>): List<ResultTableRowResource> {
        if (rows.isEmpty()) return emptyList()

        // Use batch fetching only for batch strategy, otherwise use individual fetching
        return if (properties.teamNameStrategy == TeamNameStrategy.POJO_BATCH_WITH_CACHE) {
            val teamIds = rows.map { it.teamId }
            val teamNames = teamNameResolver.resolveTeamNames(teamIds)

            rows.map { row ->
                ResultTableRowResource(
                    teamId = row.teamId.value,
                    teamName = teamNames[row.teamId] ?: "Unknown",
                    points = row.points,
                    wins = row.wins,
                    draws = row.draws,
                    losses = row.losses,
                    goalsScored = row.goalsScored,
                    goalsConceded = row.goalsConceded
                )
            }
        } else {
            rows.map { toResultTableRowResource(it) }
        }
    }
}
