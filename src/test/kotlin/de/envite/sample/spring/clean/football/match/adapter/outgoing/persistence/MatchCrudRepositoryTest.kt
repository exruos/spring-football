package de.envite.sample.spring.clean.football.match.adapter.outgoing.persistence

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(classes = [MatchPersistenceTestConfiguration::class])
@ActiveProfiles("test")
@Testcontainers
@TestConstructor(autowireMode = ALL)
internal class MatchCrudRepositoryTest(
    val matchCrudRepository: MatchCrudRepository
) {
    @Test
    fun findByIdWorks() {
        val match = matchCrudRepository.findById(24446)
        assertThat(match).isPresent
    }

    @Test
    fun findByTeamIdWorks() {
        val matches = matchCrudRepository.findByHomeTeamApiIdOrAwayTeamApiId(9906, 9906)
        assertThat(matches).isNotEmpty
    }
}
