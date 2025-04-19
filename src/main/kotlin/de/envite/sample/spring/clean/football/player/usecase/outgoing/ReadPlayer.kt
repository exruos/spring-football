package de.envite.sample.spring.clean.football.player.usecase.outgoing

import de.envite.sample.spring.clean.football.player.domain.Player
import de.envite.sample.spring.clean.football.player.domain.PlayerId

interface ReadPlayer {
    operator fun invoke(playerId: PlayerId): Player?
}
