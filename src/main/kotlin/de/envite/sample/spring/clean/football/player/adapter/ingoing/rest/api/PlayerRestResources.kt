package de.envite.sample.spring.clean.football.player.adapter.ingoing.rest.api

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("PlayerRecord")
data class PlayerRecordResource(
    val player: PlayerResource,
    val attributes: List<PlayerAttributesResource>
)

@JsonRootName("Player")
data class PlayerResource(
    val id: Int,
    val apiId: Int,
    val fifaApiId: Int,
    val name: String,
    val birthday: String,
    val height: Int,
    val weight: Int,
)

@JsonRootName("PlayerAttributes")
data class PlayerAttributesResource(
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
