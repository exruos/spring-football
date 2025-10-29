package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.match.domain.CountryId
import de.envite.sample.spring.clean.football.match.domain.Goals
import de.envite.sample.spring.clean.football.match.domain.LeagueId
import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.domain.MatchApiId
import de.envite.sample.spring.clean.football.match.domain.MatchId
import de.envite.sample.spring.clean.football.match.domain.PlayerLineup
import de.envite.sample.spring.clean.football.match.domain.Season
import de.envite.sample.spring.clean.football.match.domain.Stage
import de.envite.sample.spring.clean.football.match.domain.PlayerId
import de.envite.sample.spring.clean.football.match.domain.Day
import de.envite.sample.spring.clean.football.match.domain.TeamId

fun MatchDto.toMatch(): Match {
    return Match(
        matchId = MatchId(id),
        countryId = CountryId(countryId ?: 0),
        leagueId = LeagueId(leagueId ?: 0),
        season = Season(season ?: ""),
        stage = Stage(stage ?: 0),
        date = Day.fromString(date ?: ""),
        matchApiId = MatchApiId(matchApiId ?: 0),
        homeTeamId = TeamId(homeTeamApiId ?: 0), // Note: Using API ID as Team ID for now
        awayTeamId = TeamId(awayTeamApiId ?: 0), // Note: Using API ID as Team ID for now
        homeTeamGoal = homeTeamGoal?.let { Goals(it) },
        awayTeamGoal = awayTeamGoal?.let { Goals(it) },
        homePlayerLineup = createHomePlayerLineup(),
        awayPlayerLineup = createAwayPlayerLineup()
    )
}

private fun MatchDto.createHomePlayerLineup(): PlayerLineup {
    return PlayerLineup(
        player1 = homePlayerX1.toPlayerId(),
        player2 = homePlayerX2.toPlayerId(),
        player3 = homePlayerX3.toPlayerId(),
        player4 = homePlayerX4.toPlayerId(),
        player5 = homePlayerX5.toPlayerId(),
        player6 = homePlayerX6.toPlayerId(),
        player7 = homePlayerX7.toPlayerId(),
        player8 = homePlayerX8.toPlayerId(),
        player9 = homePlayerX9.toPlayerId(),
        player10 = homePlayerX10.toPlayerId(),
        player11 = homePlayerX11.toPlayerId()
    )
}

private fun MatchDto.createAwayPlayerLineup(): PlayerLineup {
    return PlayerLineup(
        player1 = awayPlayerX1.toPlayerId(),
        player2 = awayPlayerX2.toPlayerId(),
        player3 = awayPlayerX3.toPlayerId(),
        player4 = awayPlayerX4.toPlayerId(),
        player5 = awayPlayerX5.toPlayerId(),
        player6 = awayPlayerX6.toPlayerId(),
        player7 = awayPlayerX7.toPlayerId(),
        player8 = awayPlayerX8.toPlayerId(),
        player9 = awayPlayerX9.toPlayerId(),
        player10 = awayPlayerX10.toPlayerId(),
        player11 = awayPlayerX11.toPlayerId()
    )
}

private fun Int?.toPlayerId(): PlayerId? = this?.let { PlayerId(it) }
