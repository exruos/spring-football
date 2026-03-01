package de.envite.sample.spring.clean.football.player.adapter.ingoing.rest.api

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
class PlayerRestControllerTest(
    private val mockMvcTester: MockMvcTester,
) {

    @Test
    internal fun `finds one player`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/players/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$.name")
            .isEqualTo("Aaron Appindangoye")
    }

    @Test
    internal fun `unknown players can be processed without an error`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/players/1111")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.NOT_FOUND)
    }

    @Test
    internal fun `finds player record for one player`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/players/record/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.OK)
            .bodyJson()
            .extractingPath("$")
            .convertTo(PlayerRecordResource::class.java)
            .satisfies(
                ThrowingConsumer { resource: PlayerRecordResource ->
                    assertThat(resource.player.name).isEqualTo("Aaron Appindangoye")
                    assertThat(resource.attributes.size).isEqualTo(5)
                }
            )
    }

    @Test
    internal fun `unknown players do not have a player record`() {
        assertThat(
            mockMvcTester
                .get()
                .uri("/players/record/1111")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .hasStatus(HttpStatus.NOT_FOUND)
    }
}
