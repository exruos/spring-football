package de.envite.sample.spring.clean.football.player.adapter.ingoing.rest.api

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.`is`
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
class PlayerRestControllerTest {
    @LocalServerPort
    private var port = 0

    @Test
    internal fun `finds one player`() {
        given().get(getUri() + "/players/1")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("name", equalTo("Aaron Appindangoye"))
    }

    @Test
    internal fun `unknown players can be processed without an error`() {
        given().get(getUri() + "/players/1111")
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
    }

    @Test
    internal fun `finds player record for one player`() {
        given().get(getUri() + "/players/record/1")
            .then()
            .log().all()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("player.name", equalTo("Aaron Appindangoye"))
            .body("attributes.size()", `is`(5))
    }

    @Test
    internal fun `unknown players do not have a player record`() {
        given().get(getUri() + "/players/record/1111")
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
    }

    fun getUri() = "http://localhost:$port"
}
