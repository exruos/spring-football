package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.player.domain.Player
import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.usecase.outgoing.ReadPlayer
import kotlin.jvm.optionals.getOrNull

class PlayerRepository(
    val playerCrudRepository: PlayerCrudRepository
) : ReadPlayer {

    override fun invoke(playerId: PlayerId): Player? {
        val playerDto = playerCrudRepository.findById(playerId.value)
        return playerDto.getOrNull()?.toPLayer()
    }
}
