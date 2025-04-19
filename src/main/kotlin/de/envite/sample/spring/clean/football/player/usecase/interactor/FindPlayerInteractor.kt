package de.envite.sample.spring.clean.football.player.usecase.interactor

import de.envite.sample.spring.clean.football.player.domain.Player
import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.usecase.outgoing.ReadPlayer
import de.envite.sample.spring.clean.football.player.usecase.ingoing.FindPlayer as FindPlayerApi

internal class FindPlayerInteractor(
    private val readPlayer: ReadPlayer
) : FindPlayerApi {
    override fun invoke(playerId: PlayerId): Player? {
        val player = readPlayer(playerId)
        if (player != null) {
            return player
        }
        return null
    }
}
