package de.envite.sample.spring.clean.football

import de.envite.sample.spring.clean.football.player.adapter.ingoing.rest.api.PlayerRestModuleConfiguration
import de.envite.sample.spring.clean.football.team.adapter.ingoing.rest.api.TeamRestModuleConfiguration
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@Import(
    PlayerRestModuleConfiguration::class,
    TestcontainersConfiguration::class
)
@SpringBootTest
@ActiveProfiles("test")
class SpringCleanApplicationTests {

    @Test
    @Suppress("EmptyFunctionBlock")
    fun contextLoads() {
    }
}
