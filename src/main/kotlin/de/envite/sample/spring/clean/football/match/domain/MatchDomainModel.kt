package de.envite.sample.spring.clean.football.match.domain

import de.envite.sample.spring.clean.football.types.TypedInt
import de.envite.sample.spring.clean.football.types.TypedLocalDate
import de.envite.sample.spring.clean.football.types.TypedValue
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Match(
    val matchId: MatchId,
    val countryId: CountryId,
    val leagueId: LeagueId,
    val season: Season,
    val stage: Stage,
    val date: Day,
    val matchApiId: MatchApiId,
    val homeTeamId: TeamId,
    val awayTeamId: TeamId,
    val homeTeamGoal: Goals?,
    val awayTeamGoal: Goals?,
    val homePlayerLineup: PlayerLineup,
    val awayPlayerLineup: PlayerLineup
)

data class PlayerLineup(
    val player1: PlayerId?,
    val player2: PlayerId?,
    val player3: PlayerId?,
    val player4: PlayerId?,
    val player5: PlayerId?,
    val player6: PlayerId?,
    val player7: PlayerId?,
    val player8: PlayerId?,
    val player9: PlayerId?,
    val player10: PlayerId?,
    val player11: PlayerId?
)

// Value objects for type safety
class MatchId(value: Int) : TypedInt(value) {
    companion object {
        fun fromString(value: String): MatchId = MatchId(value.toInt())
    }
}

class CountryId(value: Int) : TypedInt(value)

class LeagueId(value: Int) : TypedInt(value)

class Season(value: String) : TypedValue<String>(value)

class Stage(value: Int) : TypedInt(value)

class MatchApiId(value: Int) : TypedInt(value)

class Goals(value: Int) : TypedInt(value)

// Module-specific ID types to avoid cross-module dependencies
class TeamId(value: Int) : TypedInt(value) {
    companion object {
        fun fromString(v: String) = v.toInt().let(::TeamId)
        fun fromLong(l: Long) = l.toInt().let(::TeamId)
    }
}

class PlayerId(value: Int) : TypedInt(value) {
    companion object {
        fun fromString(v: String) = v.toInt().let(::PlayerId)
        fun fromLong(l: Long) = l.toInt().let(::PlayerId)
    }
}

class Day(value: LocalDate) : TypedLocalDate(value) {
    companion object {
        private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        fun fromString(v: String) = LocalDateTime.parse(v, formatter).toLocalDate().let(::Day)
    }
}

// Result table representation
data class ResultTableRow(
    val teamId: TeamId,
    val points: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalsScored: Int,
    val goalsConceded: Int
)
