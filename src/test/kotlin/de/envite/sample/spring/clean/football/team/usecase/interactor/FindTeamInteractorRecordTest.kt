package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.assertFails

@ApplicationModuleTest
@ActiveProfiles("test")
@Testcontainers
@TestConstructor(autowireMode = ALL)
internal class FindTeamInteractorRecordTest(
    val getTeamRecord: FindTeamRecordInteractor,
) {
    @Test
    fun `find record for existing team`() {
        val record = getTeamRecord(TeamId(1))
        if (record != null) {
            assertThat(record).isNotNull
            assertThat(record.team.name).isEqualTo(TeamName("KRC Genk"))
            assertThat(record.attributes.size).isGreaterThan(0)
        } else {
            assertFails { }
        }
    }

    @Test
    fun `record must be null for non-existing team`() {
        val record = getTeamRecord(TeamId(9999))
        assertThat(record).isNull()
    }
}
