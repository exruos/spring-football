package de.envite.sample.spring.clean.football.player.usecase.interactor

import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.usecase.outgoing.ReadPlayer
import de.envite.sample.spring.clean.football.player.usecase.ingoing.FindPlayer as FindPlayerApi
import org.springframework.stereotype.Component

@Component
internal class FindPlayerInteractor(
    private val readPlayer: ReadPlayer
) : FindPlayerApi {
    override fun invoke(playerId: PlayerId) = readPlayer(playerId)
}
