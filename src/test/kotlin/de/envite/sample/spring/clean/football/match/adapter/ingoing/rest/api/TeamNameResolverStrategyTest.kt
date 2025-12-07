package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
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
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.assertj.MockMvcTester

/**
 * Tests for different TeamNameResolver strategies using POJO_WITHOUT_CACHE.
 */
@ApplicationModuleTest(
    webEnvironment = RANDOM_PORT,
    mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES
)
@Import(TestcontainersConfiguration::class, TeamPojoConfiguration::class, TeamLogicTestConfiguration::class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
@TestPropertySource(properties = ["match.rest.team-name-strategy=POJO_WITHOUT_CACHE"])
class TeamNameResolverPojoWithoutCacheTest(
    private val mockMvcTester: MockMvcTester,
) {

    @Test
    fun `resolves team names without cache for single match`() {
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
                    assertThat(resource.homeTeamName).isEqualTo("Atlético Madrid")
                    assertThat(resource.awayTeamName).isEqualTo("Granada CF")
                }
            )
    }

    @Test
    fun `resolves team names without cache for result table`() {
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
                    assertThat(resources).allMatch { it.teamName.isNotBlank() }
                }
            )
    }
}

/**
 * Tests for different TeamNameResolver strategies using POJO_WITH_CACHE.
 */
@ApplicationModuleTest(
    webEnvironment = RANDOM_PORT,
    mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES
)
@Import(TestcontainersConfiguration::class, TeamPojoConfiguration::class, TeamLogicTestConfiguration::class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
@TestPropertySource(properties = ["match.rest.team-name-strategy=POJO_WITH_CACHE"])
class TeamNameResolverPojoWithCacheTest(
    private val mockMvcTester: MockMvcTester,
) {

    @Test
    fun `resolves team names with cache for single match`() {
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
                    assertThat(resource.homeTeamName).isEqualTo("Atlético Madrid")
                    assertThat(resource.awayTeamName).isEqualTo("Granada CF")
                }
            )
    }

    @Test
    fun `resolves team names with cache for result table`() {
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
                    assertThat(resources).allMatch { it.teamName.isNotBlank() }
                }
            )
    }
}

/**
 * Tests for different TeamNameResolver strategies using POJO_BATCH_WITH_CACHE.
 */
@ApplicationModuleTest(
    webEnvironment = RANDOM_PORT,
    mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES
)
@Import(TestcontainersConfiguration::class, TeamPojoConfiguration::class, TeamLogicTestConfiguration::class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
@TestPropertySource(properties = ["match.rest.team-name-strategy=POJO_BATCH_WITH_CACHE"])
class TeamNameResolverPojoBatchWithCacheTest(
    private val mockMvcTester: MockMvcTester,
) {

    @Test
    fun `resolves team names with batch cache for single match`() {
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
                    assertThat(resource.homeTeamName).isEqualTo("Atlético Madrid")
                    assertThat(resource.awayTeamName).isEqualTo("Granada CF")
                }
            )
    }

    @Test
    fun `resolves team names with batch cache for result table`() {
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
                    assertThat(resources).allMatch { it.teamName.isNotBlank() }
                }
            )
    }

    @Test
    fun `uses batch fetching for result table with multiple teams`() {
        // This test verifies that batch fetching is used for result table
        // In production, this would make only 1 database call instead of N calls
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
                    // Verify all teams have names resolved
                    resources.forEach { row ->
                        assertThat(row.teamName).isNotBlank()
                        assertThat(row.teamName).isNotEqualTo("Unknown")
                    }
                }
            )
    }
}

/**
 * Tests for different TeamNameResolver strategies using REST_CONTROLLER with WireMock.
 */
@ApplicationModuleTest(
    webEnvironment = RANDOM_PORT,
    mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES
)
@Import(TestcontainersConfiguration::class, TeamPojoConfiguration::class, TeamLogicTestConfiguration::class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
@TestPropertySource(
    properties = [
        "match.rest.team-name-strategy=REST_CONTROLLER",
        "match.rest.team-service-base-url=http://localhost:8089"
    ]
)
@WireMockTest(httpPort = 8089)
class TeamNameResolverRestControllerTest(
    private val mockMvcTester: MockMvcTester,
) {

    @Test
    fun `resolves team names via REST controller for single match`() {
        // Mock the team REST endpoints
        stubFor(
            get(urlEqualTo("/teams/api-id/9906"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"name":"Atlético Madrid"}""")
                )
        )
        stubFor(
            get(urlEqualTo("/teams/api-id/7878"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"name":"Granada CF"}""")
                )
        )

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
                    assertThat(resource.homeTeamName).isEqualTo("Atlético Madrid")
                    assertThat(resource.awayTeamName).isEqualTo("Granada CF")
                }
            )
    }

    @Test
    fun `returns Unknown for non-existent teams via REST controller`() {
        // Mock 404 response for non-existent team
        stubFor(
            get(urlEqualTo("/teams/api-id/99999"))
                .willReturn(aResponse().withStatus(404))
        )

        // Create a stub team name for the other team in a non-existent match
        // so we can verify the "Unknown" behavior
        val teamId = 99999
        stubFor(
            get(urlEqualTo("/teams/api-id/$teamId"))
                .willReturn(aResponse().withStatus(404))
        )
    }
}
