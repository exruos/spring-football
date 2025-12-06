package de.envite.sample.spring.clean.football.team.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeam
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamByApiId
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamRecord
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
class TeamRestController(
    private val findTeam: FindTeam,
    private val findTeamByApiId: FindTeamByApiId,
    private val findTeamRecord: FindTeamRecord,
    private val entityToRestResourceMapper: EntityToRestResourceMapper
) {
    @RequestMapping("/teams/{id}", method = [GET])
    fun getTeamById(@PathVariable id: String): ResponseEntity<TeamResource> {
        val team = findTeam(TeamId.fromString(id))
        return if (team == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(entityToRestResourceMapper.toTeamResource(team))
        }
    }

    @RequestMapping("/teams/api-id/{apiId}", method = [GET])
    fun getTeamByApiId(@PathVariable apiId: String): ResponseEntity<TeamResource> {
        val team = findTeamByApiId(TeamApiId.fromString(apiId))
        return if (team == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(entityToRestResourceMapper.toTeamResource(team))
        }
    }

    @RequestMapping("/teams/record/{id}", method = [GET])
    fun getTeamRecordById(@PathVariable id: String): ResponseEntity<TeamRecordResource> {
        val teamRecord = findTeamRecord(TeamId.fromString(id))
        return if (teamRecord == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(entityToRestResourceMapper.toTeamRecordResource(teamRecord))
        }
    }
}
