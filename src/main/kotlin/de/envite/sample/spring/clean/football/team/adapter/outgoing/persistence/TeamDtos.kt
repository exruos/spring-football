package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("team")
data class TeamDto(
    @Id val id: Int,
    val teamApiId: Int,
    val teamFifaApiId: Int?,
    val teamLongName: String,
    val teamShortName: String,
)

@Table("team_attributes")
data class TeamAttributesDto(
    @Id val id: Int,
    val teamFifaApiId: Int?,
    val teamApiId: Int,
    val date: String,
    val buildUpPlaySpeed: Int?,
    val buildUpPlaySpeedClass: String?,
    val buildUpPlayDribbling: Int?,
    val buildUpPlayDribblingClass: String?,
    val buildUpPlayPassing: Int?,
    val buildUpPlayPassingClass: String?,
    val buildUpPlayPositioningClass: String?,
    val chanceCreationPassing: Int?,
    val chanceCreationPassingClass: String?,
    val chanceCreationCrossing: Int?,
    val chanceCreationCrossingClass: String?,
    val chanceCreationShooting: Int?,
    val chanceCreationShootingClass: String?,
    val chanceCreationPositioningClass: String?,
    val defencePressure: Int?,
    val defencePressureClass: String?,
    val defenceAggression: Int?,
    val defenceAggressionClass: String?,
    val defenceTeamWidth: Int?,
    val defenceTeamWidthClass: String?,
    val defenceDefenderLineClass: String?
)
