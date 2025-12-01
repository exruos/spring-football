package de.envite.sample.spring.clean.football.match.usecase.interactor

import de.envite.sample.spring.clean.football.match.domain.MatchId
import de.envite.sample.spring.clean.football.match.domain.Season
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@SpringBootTest(classes = [MatchLogicTestConfiguration::class])
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
internal class FindMatchInteractorTest(
    val findMatchInteractor: FindMatchInteractor,
) {
    @Test
    fun findMatchWorks() {
        val match = findMatchInteractor.invoke(MatchId(24446))
        assertThat(match).isNotNull
        assertThat(match?.season).isEqualTo(Season("2015/2016"))
    }

    @Test
    fun findUnknownMatch() {
        val match = findMatchInteractor.invoke(MatchId(9999))
        assertThat(match).isNull()
    }
}
