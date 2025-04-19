package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("player")
data class PlayerDto(
    @Id val id: Int,
    val playerApiId: Int,
    val playerFifaApiId: Int,
    val playerName: String,
    val birthday: String,
    val height: Int,
    val weight: Int,
)

@Table("player_attributes")
data class PlayerAttributesDto(
    @Id val id: Int,
    val date: String,
    val overallRating: Int?,
    val potential: Int?,
    val preferredFoot: String?,
    val attackingWorkRate: String?,
    val defensiveWorkRate: String?,
    val crossing: Int?,
    val finishing: Int?,
    val headingAccuracy: Int?,
    val shortPassing: Int?,
    val volleys: Int?,
    val dribbling: Int?,
    val curve: Int?,
    val freeKickAccuracy: Int?,
    val longPassing: Int?,
    val ballControl: Int?,
    val acceleration: Int?,
    val sprintSpeed: Int?,
    val agility: Int?,
    val reactions: Int?,
    val balance: Int?,
    val shotPower: Int?,
    val jumping: Int?,
    val stamina: Int?,
    val strength: Int?,
    val longShots: Int?,
    val aggression: Int?,
    val interceptions: Int?,
    val positioning: Int?,
    val vision: Int?,
    val penalties: Int?,
    val marking: Int?,
    val standingTackle: Int?,
    val slidingTackle: Int?,
    val gkDiving: Int?,
    val gkHandling: Int?,
    val gkKicking: Int?,
    val gkPositioning: Int?,
    val gkReflexes: Int?,
)
