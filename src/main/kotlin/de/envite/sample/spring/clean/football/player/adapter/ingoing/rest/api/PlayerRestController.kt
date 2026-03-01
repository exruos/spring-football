package de.envite.sample.spring.clean.football.player.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.usecase.ingoing.FindPlayer
import de.envite.sample.spring.clean.football.player.usecase.ingoing.FindPlayerRecord
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerRestController(
    private val findPlayer: FindPlayer,
    private val findPlayerRecord: FindPlayerRecord,
    private val entityToRestResourceMapper: EntityToRestResourceMapper
) {
    @RequestMapping("/players/{id}", method = [GET])
    fun getPlayerById(@PathVariable id: String): ResponseEntity<PlayerResource> {
        val player = findPlayer(PlayerId.fromString(id))
        return if (player == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(entityToRestResourceMapper.toPlayerResource(player))
        }
    }

    @RequestMapping("/players/record/{id}", method = [GET])
    fun getPlayerRecordById(@PathVariable id: String): ResponseEntity<PlayerRecordResource> {
        val playerRecord = findPlayerRecord(PlayerId.fromString(id))
        return if (playerRecord == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(entityToRestResourceMapper.toPlayerRecordResource(playerRecord))
        }
    }
}
