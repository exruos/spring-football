package de.envite.sample.spring.clean.football.match.usecase.interactor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.testcontainers.junit.jupiter.Testcontainers

@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
@ActiveProfiles("test")
@Testcontainers
@TestConstructor(autowireMode = ALL)
internal class GetResultTableInteractorTest(
    val getResultTableInteractor: GetResultTableInteractor,
) {
    @Test
    fun `returns result table sorted by points for test league`() {
        val resultTable = getResultTableInteractor.invoke("2023/2024", "Test League")

        assertThat(resultTable).hasSize(3)

        // Team C should be first (4 points: 1 win, 1 draw)
        val firstPlace = resultTable[0]
        assertThat(firstPlace.teamId.value).isEqualTo(10003)
        assertThat(firstPlace.points).isEqualTo(4)
        assertThat(firstPlace.wins).isEqualTo(1)
        assertThat(firstPlace.draws).isEqualTo(1)
        assertThat(firstPlace.losses).isEqualTo(0)
        assertThat(firstPlace.goalsScored).isEqualTo(4)
        assertThat(firstPlace.goalsConceded).isEqualTo(2)

        // Team A should be second (3 points: 1 win, 1 loss)
        val secondPlace = resultTable[1]
        assertThat(secondPlace.teamId.value).isEqualTo(10001)
        assertThat(secondPlace.points).isEqualTo(3)
        assertThat(secondPlace.wins).isEqualTo(1)
        assertThat(secondPlace.draws).isEqualTo(0)
        assertThat(secondPlace.losses).isEqualTo(1)
        assertThat(secondPlace.goalsScored).isEqualTo(3)
        assertThat(secondPlace.goalsConceded).isEqualTo(3)

        // Team B should be third (1 point: 1 draw, 1 loss)
        val thirdPlace = resultTable[2]
        assertThat(thirdPlace.teamId.value).isEqualTo(10002)
        assertThat(thirdPlace.points).isEqualTo(1)
        assertThat(thirdPlace.wins).isEqualTo(0)
        assertThat(thirdPlace.draws).isEqualTo(1)
        assertThat(thirdPlace.losses).isEqualTo(1)
        assertThat(thirdPlace.goalsScored).isEqualTo(3)
        assertThat(thirdPlace.goalsConceded).isEqualTo(5)
    }

    @Test
    fun `returns empty list for non-existing league`() {
        val resultTable = getResultTableInteractor.invoke("2023/2024", "Non Existing League")
        assertThat(resultTable).isEmpty()
    }

    @Test
    fun `returns empty list for non-existing season`() {
        val resultTable = getResultTableInteractor.invoke("1999/2000", "Test League")
        assertThat(resultTable).isEmpty()
    }

    @Test
    fun `calculates result table for real spain league data`() {
        val resultTable = getResultTableInteractor.invoke("2015/2016", "Spain LIGA BBVA")

        assertThat(resultTable).isNotEmpty
        // At least Atlético Madrid and Granada CF should be in the table
        val teamIds = resultTable.map { it.teamId.value }
        assertThat(teamIds).contains(9906, 7878)
    }
}
