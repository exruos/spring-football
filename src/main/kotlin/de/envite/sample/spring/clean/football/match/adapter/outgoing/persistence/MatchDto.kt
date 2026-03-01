package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("match")
data class MatchDto(
    @Id val id: Int,
    val countryId: Int?,
    val leagueId: Int?,
    val season: String?,
    val stage: Int?,
    val date: String?,
    val matchApiId: Int?,
    val homeTeamApiId: Int?,
    val awayTeamApiId: Int?,
    val homeTeamGoal: Int?,
    val awayTeamGoal: Int?,
    val homePlayerX1: Int?,
    val homePlayerX2: Int?,
    val homePlayerX3: Int?,
    val homePlayerX4: Int?,
    val homePlayerX5: Int?,
    val homePlayerX6: Int?,
    val homePlayerX7: Int?,
    val homePlayerX8: Int?,
    val homePlayerX9: Int?,
    val homePlayerX10: Int?,
    val homePlayerX11: Int?,
    val awayPlayerX1: Int?,
    val awayPlayerX2: Int?,
    val awayPlayerX3: Int?,
    val awayPlayerX4: Int?,
    val awayPlayerX5: Int?,
    val awayPlayerX6: Int?,
    val awayPlayerX7: Int?,
    val awayPlayerX8: Int?,
    val awayPlayerX9: Int?,
    val awayPlayerX10: Int?,
    val awayPlayerX11: Int?
)
