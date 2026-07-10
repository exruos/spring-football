package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
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
    @Column("team_fifa_api_id") val teamFifaApiId: Int?,
    @Column("team_api_id") val teamApiId: Int,
    val date: String,
    @Column("buildupplayspeed") val buildUpPlaySpeed: Int?,
    @Column("buildupplayspeedclass") val buildUpPlaySpeedClass: String?,
    @Column("buildupplaydribbling") val buildUpPlayDribbling: Int?,
    @Column("buildupplaydribblingclass") val buildUpPlayDribblingClass: String?,
    @Column("buildupplaypassing") val buildUpPlayPassing: Int?,
    @Column("buildupplaypassingclass") val buildUpPlayPassingClass: String?,
    @Column("buildupplaypositioningclass") val buildUpPlayPositioningClass: String?,
    @Column("chancecreationpassing") val chanceCreationPassing: Int?,
    @Column("chancecreationpassingclass") val chanceCreationPassingClass: String?,
    @Column("chancecreationcrossing") val chanceCreationCrossing: Int?,
    @Column("chancecreationcrossingclass") val chanceCreationCrossingClass: String?,
    @Column("chancecreationshooting") val chanceCreationShooting: Int?,
    @Column("chancecreationshootingclass") val chanceCreationShootingClass: String?,
    @Column("chancecreationpositioningclass") val chanceCreationPositioningClass: String?,
    @Column("defencepressure") val defencePressure: Int?,
    @Column("defencepressureclass") val defencePressureClass: String?,
    @Column("defenceaggression") val defenceAggression: Int?,
    @Column("defenceaggressionclass") val defenceAggressionClass: String?,
    @Column("defenceteamwidth") val defenceTeamWidth: Int?,
    @Column("defenceteamwidthclass") val defenceTeamWidthClass: String?,
    @Column("defencedefenderlineclass") val defenceDefenderLineClass: String?
)
