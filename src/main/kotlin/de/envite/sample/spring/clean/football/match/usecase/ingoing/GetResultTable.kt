package de.envite.sample.spring.clean.football.match.usecase.ingoing

import de.envite.sample.spring.clean.football.match.domain.ResultTableRow

interface GetResultTable {
    operator fun invoke(season: String, leagueName: String): List<ResultTableRow>
}
