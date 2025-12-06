package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.testcontainers.junit.jupiter.Testcontainers

@ApplicationModuleTest
@ActiveProfiles("test")
@Testcontainers
@TestConstructor(autowireMode = ALL)
internal class PlayerCrudRepositoryTest(
    private val playerCrudRepository: PlayerCrudRepository
) {
    @Test
    fun findSinglePlayer() {
        val player = playerCrudRepository.findById(1).get()
        assertThat(player).isNotNull
        assertThat(player.playerName).isEqualTo("Aaron Appindangoye")
    }

    @Test
    fun findPLayerAttrbutes() {
        val player = playerCrudRepository.findById(1).get()
        assertThat(player).isNotNull
        val playerAttributes = playerCrudRepository.getPlayerAttributes(player.playerFifaApiId, player.playerApiId)
        assertThat(playerAttributes.size).isEqualTo(5)
    }
}
