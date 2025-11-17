package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
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
internal class FindTeamByApiIdInteractorTest(
    val findTeamByApiIdInteractor: FindTeamByApiIdInteractor,
) {
    @Test
    fun findTeamByApiIdWorks() {
        val team = findTeamByApiIdInteractor.invoke(TeamApiId(9987))
        assertThat(team).isNotNull
        assertThat(team?.name).isEqualTo(TeamName("KRC Genk"))
    }

    @Test
    fun findUnknownTeamByApiId() {
        val team = findTeamByApiIdInteractor.invoke(TeamApiId(99999))
        assertThat(team).isNull()
    }
}