package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

data class MatchResource(
    val matchId: Int,
    val countryId: Int,
    val leagueId: Int,
    val season: String,
    val stage: Int,
    val date: String,
    val matchApiId: Int,
    val homeTeamId: Int,
    val awayTeamId: Int,
    val homeTeamName: String,
    val awayTeamName: String,
    val homeTeamGoal: Int?,
    val awayTeamGoal: Int?,
    val homePlayerLineup: PlayerLineupResource,
    val awayPlayerLineup: PlayerLineupResource
)

data class PlayerLineupResource(
    val player1: Int?,
    val player2: Int?,
    val player3: Int?,
    val player4: Int?,
    val player5: Int?,
    val player6: Int?,
    val player7: Int?,
    val player8: Int?,
    val player9: Int?,
    val player10: Int?,
    val player11: Int?
)

data class ResultTableRowResource(
    val teamId: Int,
    val teamName: String,
    val points: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalsScored: Int,
    val goalsConceded: Int
)
