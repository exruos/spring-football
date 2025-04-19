package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.player.domain.Day
import de.envite.sample.spring.clean.football.player.domain.Foot
import de.envite.sample.spring.clean.football.player.domain.Height
import de.envite.sample.spring.clean.football.player.domain.OverallRating
import de.envite.sample.spring.clean.football.player.domain.Player
import de.envite.sample.spring.clean.football.player.domain.PlayerApiId
import de.envite.sample.spring.clean.football.player.domain.PlayerAttributes
import de.envite.sample.spring.clean.football.player.domain.PlayerFifaApiId
import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.domain.PlayerName
import de.envite.sample.spring.clean.football.player.domain.Potential
import de.envite.sample.spring.clean.football.player.domain.Rate
import de.envite.sample.spring.clean.football.player.domain.Weight
import de.envite.sample.spring.clean.football.player.domain.findBy
import de.envite.sample.spring.clean.football.types.Percentage

internal fun PlayerDto.toPLayer() =
    Player(
        playerId = PlayerId(this.id),
        playerFifaApiId = PlayerFifaApiId(this.playerFifaApiId),
        playerApiId = PlayerApiId(this.playerApiId),
        name = PlayerName(this.playerName),
        birthday = Day.fromString(this.birthday),
        height = Height(this.height),
        weight = Weight(this.weight)
    )

@Suppress("CyclomaticComplexMethod")
internal fun PlayerAttributesDto.toPlayerAttributes() =
    PlayerAttributes(
        date = Day.fromString(this.date),
        overallRating = this.overallRating?.let { OverallRating(it) },
        potential = this.potential?.let { Potential(it) },
        preferredFoot = this.preferredFoot?.let { Foot::value findBy it },
        attackingWorkRate = this.attackingWorkRate?.let { Rate::value findBy it },
        defensiveWorkRate = this.defensiveWorkRate?.let { Rate::value findBy it },
        crossing = this.crossing?.let { Percentage(it) },
        finishing = this.finishing?.let { Percentage(it) },
        headingAccuracy = this.headingAccuracy?.let { Percentage(it) },
        shortPassing = this.shortPassing?.let { Percentage(it) },
        volleys = this.volleys?.let { Percentage(it) },
        dribbling = this.dribbling?.let { Percentage(it) },
        curve = this.curve?.let { Percentage(it) },
        freeKickAccuracy = this.freeKickAccuracy?.let { Percentage(it) },
        longPassing = this.longPassing?.let { Percentage(it) },
        ballControl = this.ballControl?.let { Percentage(it) },
        acceleration = this.acceleration?.let { Percentage(it) },
        sprintSpeed = this.sprintSpeed?.let { Percentage(it) },
        agility = this.agility?.let { Percentage(it) },
        reactions = this.reactions?.let { Percentage(it) },
        balance = this.balance?.let { Percentage(it) },
        shotPower = this.shotPower?.let { Percentage(it) },
        jumping = this.jumping?.let { Percentage(it) },
        stamina = this.stamina?.let { Percentage(it) },
        strength = this.strength?.let { Percentage(it) },
        longShots = this.longShots?.let { Percentage(it) },
        aggression = this.aggression?.let { Percentage(it) },
        interceptions = this.interceptions?.let { Percentage(it) },
        positioning = this.positioning?.let { Percentage(it) },
        vision = this.vision?.let { Percentage(it) },
        penalties = this.penalties?.let { Percentage(it) },
        marking = this.marking?.let { Percentage(it) },
        standingTackle = this.standingTackle?.let { Percentage(it) },
        slidingTackle = this.slidingTackle?.let { Percentage(it) },
        gkDiving = this.gkDiving?.let { Percentage(it) },
        gkHandling = this.gkHandling?.let { Percentage(it) },
        gkKicking = this.gkKicking?.let { Percentage(it) },
        gkPositioning = this.gkPositioning?.let { Percentage(it) },
        gkReflexes = this.gkReflexes?.let { Percentage(it) },
    )
