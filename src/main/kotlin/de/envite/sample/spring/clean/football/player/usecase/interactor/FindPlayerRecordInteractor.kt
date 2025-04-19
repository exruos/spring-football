package de.envite.sample.spring.clean.football.player.usecase.interactor

import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.domain.PlayerRecord
import de.envite.sample.spring.clean.football.player.usecase.outgoing.ReadPlayer
import de.envite.sample.spring.clean.football.player.usecase.outgoing.ReadPlayerAttributes
import de.envite.sample.spring.clean.football.player.usecase.ingoing.FindPlayerRecord as FindPLayerRecordApi

internal class FindPlayerRecordInteractor(
    private val readPlayer: ReadPlayer,
    private val readPlayerAttributes: ReadPlayerAttributes
) : FindPLayerRecordApi {
    override fun invoke(playerId: PlayerId): PlayerRecord? {
        val player = readPlayer(playerId)
        if (player != null) {
            val playerAttributes = readPlayerAttributes(player.playerFifaApiId, player.playerApiId)
            return PlayerRecord(
                player = player,
                attributes = playerAttributes
            )
        }
        return null
    }
}
