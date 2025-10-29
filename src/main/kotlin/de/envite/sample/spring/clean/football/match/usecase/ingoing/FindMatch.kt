package de.envite.sample.spring.clean.football.match.usecase.ingoing

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.domain.MatchId

interface FindMatch {
    operator fun invoke(matchId: MatchId): Match?
}
