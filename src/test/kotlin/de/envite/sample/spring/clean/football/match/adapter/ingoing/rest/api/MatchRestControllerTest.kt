package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.equalTo
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
class MatchRestControllerTest {
    @LocalServerPort
    private var port = 0

    @Test
    fun getMatchByIdWorks() {
        given().get(getUri() + "/matches/24446")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("matchId", equalTo(24446))
            .body("season", equalTo("2015/2016"))
    }

    @Test
    fun getMatchByIdNotFound() {
        given().get(getUri() + "/matches/9999")
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
    }

    @Test
    fun getMatchesByTeamIdWorks() {
        given().get(getUri() + "/matches/team/9906")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
    }

    @Test
    fun getMatchesByTeamIdEmpty() {
        given().get(getUri() + "/matches/team/999999")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("size()", equalTo(0))
    }

    @Test
    fun getResultTableWorks() {
        given()
            .queryParam("season", "2023/2024")
            .queryParam("leagueName", "Test League")
            .get(getUri() + "/matches/result-table")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("size()", equalTo(3))
            .body("[0].teamId", equalTo(10003))
            .body("[0].points", equalTo(4))
            .body("[0].wins", equalTo(1))
            .body("[0].draws", equalTo(1))
            .body("[0].losses", equalTo(0))
            .body("[0].goalsScored", equalTo(4))
            .body("[0].goalsConceded", equalTo(2))
            .body("[1].teamId", equalTo(10001))
            .body("[1].points", equalTo(3))
            .body("[2].teamId", equalTo(10002))
            .body("[2].points", equalTo(1))
    }

    @Test
    fun getResultTableReturnsEmptyForNonExistingLeague() {
        given()
            .queryParam("season", "2023/2024")
            .queryParam("leagueName", "Non Existing League")
            .get(getUri() + "/matches/result-table")
            .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.OK.value())
            .assertThat()
            .body("size()", equalTo(0))
    }

    fun getUri() = "http://localhost:$port"
}
