package de.envite.sample.spring.clean.football.player.usecase.outgoing

import de.envite.sample.spring.clean.football.player.domain.PlayerApiId
import de.envite.sample.spring.clean.football.player.domain.PlayerAttributes
import de.envite.sample.spring.clean.football.player.domain.PlayerFifaApiId

interface ReadPlayerAttributes {
    operator fun invoke(playerFifaApiId: PlayerFifaApiId, playerApiId: PlayerApiId): List<PlayerAttributes>
}
