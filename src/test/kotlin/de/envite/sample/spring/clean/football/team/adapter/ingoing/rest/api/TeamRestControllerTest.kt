package de.envite.sample.spring.clean.football.team.adapter.ingoing.rest.api

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.ThrowingConsumer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.test.web.servlet.assertj.MockMvcTester
import org.testcontainers.junit.jupiter.Testcontainers

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
class TeamRestControllerTest(
    private val mockMvcTester: MockMvcTester,
) {

    @Test
    internal fun `finds one team`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/teams/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$")
            .convertTo(TeamResource::class.java)
            .satisfies(
                ThrowingConsumer { resource: TeamResource ->
                    assertThat(resource.name).isEqualTo("KRC Genk")
                    assertThat(resource.shortName).isEqualTo("GEN")
                }
            )
    }

    @Test
    internal fun `unknown teams can be processed without an error`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/teams/9999")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.NOT_FOUND)
    }

    @Test
    internal fun `finds team record for one team`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/teams/record/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$")
            .convertTo(TeamRecordResource::class.java)
            .satisfies(
                ThrowingConsumer { resource: TeamRecordResource ->
                    assertThat(resource.team.name).isEqualTo("KRC Genk")
                    assertThat(resource.team.shortName).isEqualTo("GEN")
                }
            )
    }

    @Test
    internal fun `unknown teams do not have a team record`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/teams/record/9999")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.NOT_FOUND)
    }

    @Test
    internal fun `finds team by api id`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/teams/api-id/9987")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$")
            .convertTo(TeamResource::class.java)
            .satisfies(
                ThrowingConsumer { resource: TeamResource ->
                    assertThat(resource.name).isEqualTo("KRC Genk")
                    assertThat(resource.shortName).isEqualTo("GEN")
                }
            )
    }

    @Test
    internal fun `returns not found for unknown team api id`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/teams/api-id/99999")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.NOT_FOUND)
    }
}
