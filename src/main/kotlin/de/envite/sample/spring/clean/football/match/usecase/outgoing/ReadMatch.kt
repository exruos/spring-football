package de.envite.sample.spring.clean.football.match.usecase.outgoing

import de.envite.sample.spring.clean.football.match.domain.Match
import de.envite.sample.spring.clean.football.match.domain.MatchId

interface ReadMatch {
    operator fun invoke(matchId: MatchId): Match?
}
