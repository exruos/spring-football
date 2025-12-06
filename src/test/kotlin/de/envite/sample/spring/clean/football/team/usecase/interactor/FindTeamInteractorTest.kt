package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamName
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
internal class FindTeamInteractorTest(
    val findTeamInteractor: FindTeamInteractor,
) {
    @Test
    fun findTeamWorks() {
        val team = findTeamInteractor.invoke(TeamId(1))
        assertThat(team).isNotNull
        assertThat(team?.name).isEqualTo(TeamName("KRC Genk"))
    }

    @Test
    fun findUnknownTeam() {
        val team = findTeamInteractor.invoke(TeamId(9999))
        assertThat(team).isNull()
    }
}
