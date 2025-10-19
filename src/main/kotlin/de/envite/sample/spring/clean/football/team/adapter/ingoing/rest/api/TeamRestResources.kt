package de.envite.sample.spring.clean.football.team.adapter.ingoing.rest.api

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("TeamRecord")
data class TeamRecordResource(
    val team: TeamResource,
    val attributes: List<TeamAttributesResource>
)

@JsonRootName("Team")
data class TeamResource(
    val id: Int,
    val apiId: Int,
    val fifaApiId: Int,
    val name: String,
    val shortName: String,
)

@JsonRootName("TeamAttributes")
data class TeamAttributesResource(
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
