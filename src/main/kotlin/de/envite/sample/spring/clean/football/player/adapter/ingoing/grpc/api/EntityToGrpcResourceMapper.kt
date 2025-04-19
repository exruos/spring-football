package de.envite.sample.spring.clean.football.player.adapter.ingoing.grpc.api

import de.envite.sample.spring.clean.football.player.domain.Player
import de.envite.sample.spring.clean.football.player.domain.PlayerRecord
import de.envite.sample.spring.clean.football.proto.PlayerAttributes
import de.envite.sample.spring.clean.football.proto.PlayerRecordReply
import de.envite.sample.spring.clean.football.proto.PlayerReply
import kotlin.random.Random
import de.envite.sample.spring.clean.football.player.domain.PlayerAttributes as PlayerDomainAttributes

class EntityToGrpcResourceMapper {
    fun toPlayerReply(player: Player): PlayerReply =
        PlayerReply.newBuilder().setId(player.playerId.value.toLong()).setPlayerApiId(player.playerApiId.value)
            .setPlayerFifaApiId(player.playerFifaApiId.value).setPlayerName(player.name.value)
            .setBirthday(player.birthday.value.toString()).setHeight(player.height.value).setWeight(player.weight.value)
            .build()

    fun createPlayerRecordReply(playerRecord: PlayerRecord): PlayerRecordReply {
        val playerAttributes = playerRecord.attributes.map { createPlayerAttributes(it) }.toList()

        return PlayerRecordReply.newBuilder().setPlayer(toPlayerReply((playerRecord.player)))
            .addAllAttributes(playerAttributes).build()
    }

    @Suppress("CyclomaticComplexMethod", "LongMethod")
    private fun createPlayerAttributes(playerDomainAttributes: PlayerDomainAttributes): PlayerAttributes {
        val builder =
            PlayerAttributes.newBuilder().setId(Random.nextLong()).setDate(playerDomainAttributes.date.toString())
        playerDomainAttributes.attackingWorkRate?.let {
            builder.setAttackingWorkRate(playerDomainAttributes.attackingWorkRate.value)
        }
        playerDomainAttributes.defensiveWorkRate?.let {
            builder.setAttackingWorkRate(playerDomainAttributes.defensiveWorkRate.value)
        }
        playerDomainAttributes.overallRating?.let {
            builder.setOverallRating(playerDomainAttributes.overallRating.value)
        }
        playerDomainAttributes.potential?.let { builder.setPotential(playerDomainAttributes.potential.value) }
        playerDomainAttributes.penalties?.let { builder.setPenalties(playerDomainAttributes.penalties.value) }
        playerDomainAttributes.crossing?.let { builder.setCrossing(playerDomainAttributes.crossing.value) }
        playerDomainAttributes.finishing?.let { builder.setFinishing(playerDomainAttributes.finishing.value) }
        playerDomainAttributes.headingAccuracy?.let {
            builder.setHeadingAccuracy(playerDomainAttributes.headingAccuracy.value)
        }
        playerDomainAttributes.shortPassing?.let { builder.setShortPassing(playerDomainAttributes.shortPassing.value) }
        playerDomainAttributes.volleys?.let { builder.setVolleys(playerDomainAttributes.volleys.value) }
        playerDomainAttributes.dribbling?.let { builder.setDribbling(playerDomainAttributes.dribbling.value) }
        playerDomainAttributes.curve?.let { builder.setCurve(playerDomainAttributes.curve.value) }
        playerDomainAttributes.freeKickAccuracy?.let {
            builder.setFreeKickAccuracy(playerDomainAttributes.freeKickAccuracy.value)
        }
        playerDomainAttributes.longPassing?.let { builder.setLongPassing(playerDomainAttributes.longPassing.value) }
        playerDomainAttributes.ballControl?.let { builder.setBallControl(playerDomainAttributes.ballControl.value) }
        playerDomainAttributes.acceleration?.let { builder.setAcceleration(playerDomainAttributes.acceleration.value) }
        playerDomainAttributes.sprintSpeed?.let { builder.setSprintSpeed(playerDomainAttributes.sprintSpeed.value) }
        playerDomainAttributes.agility?.let { builder.setAgility(playerDomainAttributes.agility.value) }
        playerDomainAttributes.reactions?.let { builder.setReactions(playerDomainAttributes.reactions.value) }
        playerDomainAttributes.balance?.let { builder.setBalance(playerDomainAttributes.balance.value) }
        playerDomainAttributes.shotPower?.let { builder.setShotPower(playerDomainAttributes.shotPower.value) }
        playerDomainAttributes.jumping?.let { builder.setJumping(playerDomainAttributes.jumping.value) }
        playerDomainAttributes.stamina?.let { builder.setStamina(playerDomainAttributes.stamina.value) }
        playerDomainAttributes.strength?.let { builder.setStrength(playerDomainAttributes.strength.value) }
        playerDomainAttributes.longShots?.let { builder.setLongShots(playerDomainAttributes.longShots.value) }
        playerDomainAttributes.aggression?.let { builder.setAggression(playerDomainAttributes.aggression.value) }
        playerDomainAttributes.interceptions?.let {
            builder.setInterceptions(playerDomainAttributes.interceptions.value)
        }
        playerDomainAttributes.positioning?.let { builder.setPositioning(playerDomainAttributes.positioning.value) }
        playerDomainAttributes.vision?.let { builder.setVision(playerDomainAttributes.vision.value) }
        playerDomainAttributes.penalties?.let { builder.setPenalties(playerDomainAttributes.penalties.value) }
        playerDomainAttributes.marking?.let { builder.setMarking(playerDomainAttributes.marking.value) }
        playerDomainAttributes.standingTackle?.let {
            builder.setStandingTackle(playerDomainAttributes.standingTackle.value)
        }
        playerDomainAttributes.slidingTackle?.let {
            builder.setSlidingTackle(playerDomainAttributes.slidingTackle.value)
        }
        playerDomainAttributes.gkDiving?.let { builder.setGkDiving(playerDomainAttributes.gkDiving.value) }
        playerDomainAttributes.gkHandling?.let { builder.setGkHandling(playerDomainAttributes.gkHandling.value) }
        playerDomainAttributes.gkKicking?.let { builder.setGkKicking(playerDomainAttributes.gkKicking.value) }
        playerDomainAttributes.gkPositioning?.let {
            builder.setGkPositioning(playerDomainAttributes.gkPositioning.value)
        }
        playerDomainAttributes.gkReflexes?.let { builder.setGkReflexes(playerDomainAttributes.gkReflexes.value) }

        return builder.build()
    }
}
