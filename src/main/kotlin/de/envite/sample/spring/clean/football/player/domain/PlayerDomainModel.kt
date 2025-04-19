package de.envite.sample.spring.clean.football.player.domain

import de.envite.sample.spring.clean.football.types.Percentage

data class Player(
    val playerId: PlayerId,
    val name: PlayerName,
    val birthday: Day,
    val height: Height,
    val weight: Weight,
    val playerApiId: PlayerApiId,
    val playerFifaApiId: PlayerFifaApiId
)

data class PlayerRecord(
    val player: Player,
    val attributes: List<PlayerAttributes>
)

data class PlayerAttributes(
    val date: Day,
    val overallRating: OverallRating?,
    val potential: Potential?,
    val preferredFoot: Foot?,
    val attackingWorkRate: Rate?,
    val defensiveWorkRate: Rate?,
    val crossing: Percentage?,
    val finishing: Percentage?,
    val headingAccuracy: Percentage?,
    val shortPassing: Percentage?,
    val volleys: Percentage?,
    val dribbling: Percentage?,
    val curve: Percentage?,
    val freeKickAccuracy: Percentage?,
    val longPassing: Percentage?,
    val ballControl: Percentage?,
    val acceleration: Percentage?,
    val sprintSpeed: Percentage?,
    val agility: Percentage?,
    val reactions: Percentage?,
    val balance: Percentage?,
    val shotPower: Percentage?,
    val jumping: Percentage?,
    val stamina: Percentage?,
    val strength: Percentage?,
    val longShots: Percentage?,
    val aggression: Percentage?,
    val interceptions: Percentage?,
    val positioning: Percentage?,
    val vision: Percentage?,
    val penalties: Percentage?,
    val marking: Percentage?,
    val standingTackle: Percentage?,
    val slidingTackle: Percentage?,
    val gkDiving: Percentage?,
    val gkHandling: Percentage?,
    val gkKicking: Percentage?,
    val gkPositioning: Percentage?,
    val gkReflexes: Percentage?,
)
