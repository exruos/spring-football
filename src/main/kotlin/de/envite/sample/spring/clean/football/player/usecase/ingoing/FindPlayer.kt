package de.envite.sample.spring.clean.football.player.usecase.ingoing

import de.envite.sample.spring.clean.football.player.domain.Player
import de.envite.sample.spring.clean.football.player.domain.PlayerId

interface FindPlayer {
    operator fun invoke(playerId: PlayerId): Player?
}
