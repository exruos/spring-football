package de.envite.sample.spring.clean.football.match.usecase.interactor

import de.envite.sample.spring.clean.football.match.domain.TeamId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@SpringBootTest(classes = [MatchLogicTestConfiguration::class])
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
internal class FindMatchesByTeamInteractorTest(
    val findMatchesByTeamInteractor: FindMatchesByTeamInteractor,
) {
    @Test
    fun findMatchesByTeamWorks() {
        // Using a team API ID that should exist in the database
        val matches = findMatchesByTeamInteractor.invoke(TeamId(9906))
        assertThat(matches).isNotEmpty
        assertThat(matches).allMatch { match ->
            match.homeTeamId.value == 9906 || match.awayTeamId.value == 9906
        }
    }

    @Test
    fun findMatchesByUnknownTeam() {
        val matches = findMatchesByTeamInteractor.invoke(TeamId(999999))
        assertThat(matches).isEmpty()
    }
}
