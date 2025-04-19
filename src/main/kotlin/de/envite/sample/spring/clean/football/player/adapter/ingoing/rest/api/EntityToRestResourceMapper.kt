package de.envite.sample.spring.clean.football.player.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.player.domain.Player
import de.envite.sample.spring.clean.football.player.domain.PlayerAttributes
import de.envite.sample.spring.clean.football.player.domain.PlayerRecord

/**
 * Wir müssen nach Refactoring in die andere Richtung mappen.
 * Dies lässt sich nicht im Domain Model integrieren und aufgrund DataClass
 * mit parametrisierten Konstruktor auch nicht in der Resource-Klasse.
 * Ist das jetzt der Java-Way und würde man in Kotlin anders machen?
 * Wenn das auch der Kotlin-Way ist, ergibt dann das Mapping in der Resource-Klasse noch Sinn?
 * Auf der ausgehende Seite, sprich Persistenz-Adapter, funktioniert es in der DTO-Klasse.
 */
class EntityToRestResourceMapper {

    fun toPlayerRecordResource(entity: PlayerRecord): PlayerRecordResource {
        return PlayerRecordResource(
            player = this.toPlayerResource(entity.player),
            // wieso ist das hier eine liste?
            attributes = entity.attributes.map { this.toPlayerAttributesResource(it) }
        )
    }

    fun toPlayerResource(entity: Player): PlayerResource {
        return PlayerResource(
            id = entity.playerId.value,
            name = entity.name.value,
            birthday = entity.birthday.toString(),
            height = entity.height.value,
            weight = entity.weight.value,
            apiId = entity.playerApiId.value,
            fifaApiId = entity.playerFifaApiId.value
        )
    }

    private fun toPlayerAttributesResource(entity: PlayerAttributes): PlayerAttributesResource {
        return PlayerAttributesResource(
            date = entity.date.toString(),
            overallRating = entity.overallRating?.value,
            potential = entity.potential?.value,
            preferredFoot = entity.preferredFoot?.value,
            attackingWorkRate = entity.attackingWorkRate?.value,
            defensiveWorkRate = entity.defensiveWorkRate?.value,
            crossing = entity.crossing?.value,
            finishing = entity.finishing?.value,
            headingAccuracy = entity.headingAccuracy?.value,
            shortPassing = entity.shortPassing?.value,
            volleys = entity.volleys?.value,
            dribbling = entity.dribbling?.value,
            curve = entity.curve?.value,
            freeKickAccuracy = entity.freeKickAccuracy?.value,
            longPassing = entity.longPassing?.value,
            ballControl = entity.ballControl?.value,
            acceleration = entity.acceleration?.value,
            sprintSpeed = entity.sprintSpeed?.value,
            agility = entity.agility?.value,
            reactions = entity.reactions?.value,
            balance = entity.balance?.value,
            shotPower = entity.shotPower?.value,
            jumping = entity.jumping?.value,
            stamina = entity.stamina?.value,
            strength = entity.strength?.value,
            longShots = entity.longShots?.value,
            aggression = entity.aggression?.value,
            interceptions = entity.interceptions?.value,
            positioning = entity.positioning?.value,
            vision = entity.vision?.value,
            penalties = entity.penalties?.value,
            marking = entity.marking?.value,
            standingTackle = entity.standingTackle?.value,
            slidingTackle = entity.slidingTackle?.value,
            gkDiving = entity.gkDiving?.value,
            gkHandling = entity.gkHandling?.value,
            gkKicking = entity.gkKicking?.value,
            gkPositioning = entity.gkPositioning?.value,
            gkReflexes = entity.gkReflexes?.value
        )
    }
}
