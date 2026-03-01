package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.team.domain.BuildUpPlayDribbling
import de.envite.sample.spring.clean.football.team.domain.BuildUpPlayPassing
import de.envite.sample.spring.clean.football.team.domain.BuildUpPlaySpeed
import de.envite.sample.spring.clean.football.team.domain.ChanceCreationCrossing
import de.envite.sample.spring.clean.football.team.domain.ChanceCreationPassing
import de.envite.sample.spring.clean.football.team.domain.ChanceCreationShooting
import de.envite.sample.spring.clean.football.team.domain.Day
import de.envite.sample.spring.clean.football.team.domain.DefenceAggression
import de.envite.sample.spring.clean.football.team.domain.DefencePressure
import de.envite.sample.spring.clean.football.team.domain.DefenceTeamWidth
import de.envite.sample.spring.clean.football.team.domain.PlayClass
import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.domain.TeamAttributes
import de.envite.sample.spring.clean.football.team.domain.TeamFifaApiId
import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamName
import de.envite.sample.spring.clean.football.team.domain.TeamShortName
import de.envite.sample.spring.clean.football.team.domain.findBy

internal fun TeamDto.toTeam() =
    Team(
        teamId = TeamId(this.id),
        teamFifaApiId = this.teamFifaApiId?.let { TeamFifaApiId(it) },
        teamApiId = TeamApiId(this.teamApiId),
        name = TeamName(this.teamLongName),
        shortName = TeamShortName(this.teamShortName)
    )

@Suppress("CyclomaticComplexMethod")
internal fun TeamAttributesDto.toTeamAttributes() =
    TeamAttributes(
        date = Day.fromString(this.date),
        buildUpPlaySpeed = this.buildUpPlaySpeed?.let { BuildUpPlaySpeed(it) },
        buildUpPlaySpeedClass = this.buildUpPlaySpeedClass?.let { PlayClass::value findBy it },
        buildUpPlayDribbling = this.buildUpPlayDribbling?.let { BuildUpPlayDribbling(it) },
        buildUpPlayDribblingClass = this.buildUpPlayDribblingClass?.let { PlayClass::value findBy it },
        buildUpPlayPassing = this.buildUpPlayPassing?.let { BuildUpPlayPassing(it) },
        buildUpPlayPassingClass = this.buildUpPlayPassingClass?.let { PlayClass::value findBy it },
        buildUpPlayPositioningClass = this.buildUpPlayPositioningClass?.let { PlayClass::value findBy it },
        chanceCreationPassing = this.chanceCreationPassing?.let { ChanceCreationPassing(it) },
        chanceCreationPassingClass = this.chanceCreationPassingClass?.let { PlayClass::value findBy it },
        chanceCreationCrossing = this.chanceCreationCrossing?.let { ChanceCreationCrossing(it) },
        chanceCreationCrossingClass = this.chanceCreationCrossingClass?.let { PlayClass::value findBy it },
        chanceCreationShooting = this.chanceCreationShooting?.let { ChanceCreationShooting(it) },
        chanceCreationShootingClass = this.chanceCreationShootingClass?.let { PlayClass::value findBy it },
        chanceCreationPositioningClass = this.chanceCreationPositioningClass?.let { PlayClass::value findBy it },
        defencePressure = this.defencePressure?.let { DefencePressure(it) },
        defencePressureClass = this.defencePressureClass?.let { PlayClass::value findBy it },
        defenceAggression = this.defenceAggression?.let { DefenceAggression(it) },
        defenceAggressionClass = this.defenceAggressionClass?.let { PlayClass::value findBy it },
        defenceTeamWidth = this.defenceTeamWidth?.let { DefenceTeamWidth(it) },
        defenceTeamWidthClass = this.defenceTeamWidthClass?.let { PlayClass::value findBy it },
        defenceDefenderLineClass = this.defenceDefenderLineClass?.let { PlayClass::value findBy it }
    )
