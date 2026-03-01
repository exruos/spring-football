package de.envite.sample.spring.clean.football.team.domain

data class Team(
    val teamId: TeamId,
    val name: TeamName,
    val shortName: TeamShortName,
    val teamApiId: TeamApiId,
    val teamFifaApiId: TeamFifaApiId?
)

data class TeamRecord(
    val team: Team,
    val attributes: List<TeamAttributes>
)

data class TeamAttributes(
    val date: Day,
    val buildUpPlaySpeed: BuildUpPlaySpeed?,
    val buildUpPlaySpeedClass: PlayClass?,
    val buildUpPlayDribbling: BuildUpPlayDribbling?,
    val buildUpPlayDribblingClass: PlayClass?,
    val buildUpPlayPassing: BuildUpPlayPassing?,
    val buildUpPlayPassingClass: PlayClass?,
    val buildUpPlayPositioningClass: PlayClass?,
    val chanceCreationPassing: ChanceCreationPassing?,
    val chanceCreationPassingClass: PlayClass?,
    val chanceCreationCrossing: ChanceCreationCrossing?,
    val chanceCreationCrossingClass: PlayClass?,
    val chanceCreationShooting: ChanceCreationShooting?,
    val chanceCreationShootingClass: PlayClass?,
    val chanceCreationPositioningClass: PlayClass?,
    val defencePressure: DefencePressure?,
    val defencePressureClass: PlayClass?,
    val defenceAggression: DefenceAggression?,
    val defenceAggressionClass: PlayClass?,
    val defenceTeamWidth: DefenceTeamWidth?,
    val defenceTeamWidthClass: PlayClass?,
    val defenceDefenderLineClass: PlayClass?
)
