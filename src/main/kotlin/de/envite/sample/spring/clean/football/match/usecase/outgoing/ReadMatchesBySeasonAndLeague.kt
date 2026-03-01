package de.envite.sample.spring.clean.football.match.usecase.outgoing

import de.envite.sample.spring.clean.football.match.domain.Match

interface ReadMatchesBySeasonAndLeague {
    operator fun invoke(season: String, leagueName: String): List<Match>
}
