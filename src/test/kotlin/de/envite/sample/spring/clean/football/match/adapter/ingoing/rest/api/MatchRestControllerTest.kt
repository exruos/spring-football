package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.TestcontainersConfiguration
import de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api.TeamPojoConfiguration
import de.envite.sample.spring.clean.football.team.usecase.interactor.TeamLogicTestConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.ThrowingConsumer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.test.web.servlet.assertj.MockMvcTester

@ApplicationModuleTest(
    webEnvironment = RANDOM_PORT,
    mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES
)
@Import(TestcontainersConfiguration::class, TeamPojoConfiguration::class, TeamLogicTestConfiguration::class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
class MatchRestControllerTest(
    private val mockMvcTester: MockMvcTester,
) {

    @Test
    fun getMatchByIdWorks() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/match/24446")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$")
            .convertTo(MatchResource::class.java)
            .satisfies(
                ThrowingConsumer { resource: MatchResource ->
                    assertThat(resource.matchId).isEqualTo(24446)
                    assertThat(resource.season).isEqualTo("2015/2016")
                    assertThat(resource.homeTeamName).isNotBlank()
                    assertThat(resource.awayTeamName).isNotBlank()
                }
            )
    }

    @Test
    fun getMatchByIdNotFound() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/match/9999")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.NOT_FOUND)
    }

    @Test
    fun getMatchesByTeamIdWorks() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/match/team/9906")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
    }

    @Test
    fun getMatchesByTeamIdEmpty() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/match/team/999999")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$.length()")
            .isEqualTo(0)
    }

    @Test
    @Suppress("LongMethod")
    fun getResultTableWorks() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/match/result-table?season=2023/2024&leagueName=Test League")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$")
            .convertTo(Array<ResultTableRowResource>::class.java)
            .satisfies(
                ThrowingConsumer { resources: Array<ResultTableRowResource> ->
                    assertThat(resources).hasSize(3)
                    assertThat(resources[0].teamId).isEqualTo(10003)
                    assertThat(resources[0].teamName).isNotBlank()
                    assertThat(resources[0].points).isEqualTo(4)
                    assertThat(resources[0].wins).isEqualTo(1)
                    assertThat(resources[0].draws).isEqualTo(1)
                    assertThat(resources[0].losses).isEqualTo(0)
                    assertThat(resources[0].goalsScored).isEqualTo(4)
                    assertThat(resources[0].goalsConceded).isEqualTo(2)
                    assertThat(resources[1].teamId).isEqualTo(10001)
                    assertThat(resources[1].teamName).isNotBlank()
                    assertThat(resources[1].points).isEqualTo(3)
                    assertThat(resources[2].teamId).isEqualTo(10002)
                    assertThat(resources[2].teamName).isNotBlank()
                    assertThat(resources[2].points).isEqualTo(1)
                }
            )
    }

    @Test
    fun getResultTableReturnsEmptyForNonExistingLeague() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/match/result-table?season=2023/2024&leagueName=Non Existing League")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$.length()")
            .isEqualTo(0)
    }
}
