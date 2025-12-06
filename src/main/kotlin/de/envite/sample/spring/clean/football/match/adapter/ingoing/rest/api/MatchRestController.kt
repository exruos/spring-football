package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.match.domain.MatchId
import de.envite.sample.spring.clean.football.match.domain.TeamId
import de.envite.sample.spring.clean.football.match.usecase.ingoing.FindMatch
import de.envite.sample.spring.clean.football.match.usecase.ingoing.FindMatchesByTeam
import de.envite.sample.spring.clean.football.match.usecase.ingoing.GetResultTable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MatchRestController(
    private val findMatch: FindMatch,
    private val findMatchesByTeam: FindMatchesByTeam,
    private val getResultTable: GetResultTable,
    private val entityToRestResourceMapper: EntityToRestResourceMapper
) {
    @RequestMapping("/match/{id}", method = [GET])
    fun getMatchById(@PathVariable id: String): ResponseEntity<MatchResource> {
        val match = findMatch(MatchId.fromString(id))
        return if (match == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(entityToRestResourceMapper.toMatchResource(match))
        }
    }

    @RequestMapping("/match/team/{teamId}", method = [GET])
    fun getMatchesByTeamId(@PathVariable teamId: String): ResponseEntity<List<MatchResource>> {
        val matches = findMatchesByTeam(TeamId.fromString(teamId))
        val matchResources = matches.map { entityToRestResourceMapper.toMatchResource(it) }
        return ResponseEntity.ok().body(matchResources)
    }

    @RequestMapping("/match/result-table", method = [GET])
    fun getResultTableBySeasonAndLeague(
        @RequestParam season: String,
        @RequestParam leagueName: String
    ): ResponseEntity<List<ResultTableRowResource>> {
        val resultTable = getResultTable(season, leagueName)
        val resultTableResources = resultTable.map { entityToRestResourceMapper.toResultTableRowResource(it) }
        return ResponseEntity.ok().body(resultTableResources)
    }
}
