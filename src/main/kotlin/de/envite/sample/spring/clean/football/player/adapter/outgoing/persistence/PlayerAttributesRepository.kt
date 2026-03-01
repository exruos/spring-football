package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import de.envite.sample.spring.clean.football.player.domain.PlayerApiId
import de.envite.sample.spring.clean.football.player.domain.PlayerAttributes
import de.envite.sample.spring.clean.football.player.domain.PlayerFifaApiId
import de.envite.sample.spring.clean.football.player.usecase.outgoing.ReadPlayerAttributes
import org.springframework.stereotype.Component

@Component
class PlayerAttributesRepository(
    val playerCrudRepository: PlayerCrudRepository
) : ReadPlayerAttributes {

    override fun invoke(playerFifaApiId: PlayerFifaApiId, playerApiId: PlayerApiId): List<PlayerAttributes> {
        val attributes = playerCrudRepository.getPlayerAttributes(playerFifaApiId.value, playerApiId.value)
        return attributes.map { it.toPlayerAttributes() }.toList()
    }
}
