package de.envite.sample.spring.clean.football.player.usecase.interactor

import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.domain.PlayerName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest()
@ActiveProfiles("test")
@Testcontainers
@TestConstructor(autowireMode = ALL)
internal class FindPlayerInteractorTest(
    val findPlayerInteractor: FindPlayerInteractor,
) {
    @Test
    fun findPlayerWorks() {
        val player = findPlayerInteractor.invoke(PlayerId(1))
        assertThat(player).isNotNull
        assertThat(player?.name).isEqualTo(PlayerName("Aaron Appindangoye"))
    }

    @Test
    fun findUnknownPlayer() {
        val player = findPlayerInteractor.invoke(PlayerId(1111))
        assertThat(player).isNull()
    }
}
