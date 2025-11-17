package de.envite.sample.spring.clean.football.team.adapter.ingoing.rest.api

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matchers.greaterThan
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
@Testcontainers
@TestConstructor(autowireMode = ALL)
class TeamRestControllerTest {
    @LocalServerPort
    private var port = 0

    @Test
    internal fun `finds one team`() {
        given().get(getUri() + "/teams/1")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("name", equalTo("KRC Genk"))
            .body("shortName", equalTo("GEN"))
    }

    @Test
    internal fun `unknown teams can be processed without an error`() {
        given().get(getUri() + "/teams/9999")
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
    }

    @Test
    internal fun `finds team record for one team`() {
        given().get(getUri() + "/teams/record/1")
            .then()
            .log().all()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("team.name", equalTo("KRC Genk"))
            .body("team.shortName", equalTo("GEN"))
            .body("attributes.size()", greaterThan(0))
    }

    @Test
    internal fun `unknown teams do not have a team record`() {
        given().get(getUri() + "/teams/record/9999")
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
    }

    @Test
    internal fun `finds team by api id`() {
        given().get(getUri() + "/teams/api-id/9987")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("name", equalTo("KRC Genk"))
            .body("shortName", equalTo("GEN"))
    }

    @Test
    internal fun `returns not found for unknown team api id`() {
        given().get(getUri() + "/teams/api-id/99999")
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
    }

    fun getUri() = "http://localhost:$port"
}
