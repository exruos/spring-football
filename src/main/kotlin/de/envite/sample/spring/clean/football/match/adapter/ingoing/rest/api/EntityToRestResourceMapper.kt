package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.domain.PlayerLineup
import de.envite.sample.spring.clean.football.match.domain.ResultTableRow
import org.springframework.stereotype.Component

@Component
class EntityToRestResourceMapper {

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
            points = row.points,
            wins = row.wins,
            draws = row.draws,
            losses = row.losses,
            goalsScored = row.goalsScored,
            goalsConceded = row.goalsConceded
        )
    }
}
