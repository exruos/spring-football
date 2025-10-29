package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.match.domain.MatchId
import de.envite.sample.spring.clean.football.match.usecase.ingoing.FindMatch
import de.envite.sample.spring.clean.football.match.usecase.ingoing.FindMatchesByTeam
import de.envite.sample.spring.clean.football.match.domain.TeamId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
class MatchRestController(
    private val findMatch: FindMatch,
    private val findMatchesByTeam: FindMatchesByTeam,
    private val entityToRestResourceMapper: EntityToRestResourceMapper
) {
    @RequestMapping("/matches/{id}", method = [GET])
    fun getMatchById(@PathVariable id: String): ResponseEntity<MatchResource?> {
        val match = findMatch(MatchId.fromString(id))
        return if (match == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(entityToRestResourceMapper.toMatchResource(match))
        }
    }

    @RequestMapping("/matches/team/{teamId}", method = [GET])
    fun getMatchesByTeamId(@PathVariable teamId: String): ResponseEntity<List<MatchResource>> {
        val matches = findMatchesByTeam(TeamId.fromString(teamId))
        val matchResources = matches.map { entityToRestResourceMapper.toMatchResource(it) }
        return ResponseEntity.ok().body(matchResources)
    }
}
