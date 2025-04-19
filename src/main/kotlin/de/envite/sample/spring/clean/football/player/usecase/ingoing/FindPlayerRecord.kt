package de.envite.sample.spring.clean.football.player.usecase.ingoing

import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.domain.PlayerRecord

interface FindPlayerRecord {
    operator fun invoke(playerId: PlayerId): PlayerRecord?
}
