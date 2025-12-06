package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.domain.TeamFifaApiId
import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamName
import de.envite.sample.spring.clean.football.team.domain.TeamShortName
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeam
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BatchTeamNameQueryTest {

    private val findTeam = mockk<FindTeam>()
    private lateinit var batchTeamNameQuery: BatchTeamNameQuery

    @BeforeEach
    fun setup() {
        clearMocks(findTeam)
        batchTeamNameQuery = BatchTeamNameQuery(findTeam)
    }

    @Test
    fun `getTeamNames returns map of team names for existing teams`() {
        // Given
        val teamId1 = TeamId(1)
        val teamId2 = TeamId(2)
        val teamId3 = TeamId(3)

        val team1 = Team(
            teamId = teamId1,
            name = TeamName("KRC Genk"),
            shortName = TeamShortName("GEN"),
            teamApiId = TeamApiId(9987),
            teamFifaApiId = TeamFifaApiId(673)
        )
        val team2 = Team(
            teamId = teamId2,
            name = TeamName("Beerschot AC"),
            shortName = TeamShortName("BAC"),
            teamApiId = TeamApiId(9993),
            teamFifaApiId = TeamFifaApiId(675)
        )
        val team3 = Team(
            teamId = teamId3,
            name = TeamName("SV Zulte-Waregem"),
            shortName = TeamShortName("ZUL"),
            teamApiId = TeamApiId(10000),
            teamFifaApiId = TeamFifaApiId(15005)
        )

        every { findTeam(teamId1) } returns team1
        every { findTeam(teamId2) } returns team2
        every { findTeam(teamId3) } returns team3

        // When
        val result = batchTeamNameQuery.getTeamNames(listOf(teamId1, teamId2, teamId3))

        // Then
        assertThat(result).hasSize(3)
        assertThat(result[teamId1]).isEqualTo(TeamName("KRC Genk"))
        assertThat(result[teamId2]).isEqualTo(TeamName("Beerschot AC"))
        assertThat(result[teamId3]).isEqualTo(TeamName("SV Zulte-Waregem"))
        verify(exactly = 1) { findTeam(teamId1) }
        verify(exactly = 1) { findTeam(teamId2) }
        verify(exactly = 1) { findTeam(teamId3) }
    }

    @Test
    fun `getTeamNames returns empty map when all teams do not exist`() {
        // Given
        val teamId1 = TeamId(9991)
        val teamId2 = TeamId(9992)

        every { findTeam(teamId1) } returns null
        every { findTeam(teamId2) } returns null

        // When
        val result = batchTeamNameQuery.getTeamNames(listOf(teamId1, teamId2))

        // Then
        assertThat(result).isEmpty()
        verify(exactly = 1) { findTeam(teamId1) }
        verify(exactly = 1) { findTeam(teamId2) }
    }

    @Test
    fun `getTeamNames returns only existing teams in map`() {
        // Given
        val teamId1 = TeamId(1)
        val teamId2 = TeamId(9999)
        val teamId3 = TeamId(3)

        val team1 = Team(
            teamId = teamId1,
            name = TeamName("KRC Genk"),
            shortName = TeamShortName("GEN"),
            teamApiId = TeamApiId(9987),
            teamFifaApiId = TeamFifaApiId(673)
        )
        val team3 = Team(
            teamId = teamId3,
            name = TeamName("SV Zulte-Waregem"),
            shortName = TeamShortName("ZUL"),
            teamApiId = TeamApiId(10000),
            teamFifaApiId = TeamFifaApiId(15005)
        )

        every { findTeam(teamId1) } returns team1
        every { findTeam(teamId2) } returns null
        every { findTeam(teamId3) } returns team3

        // When
        val result = batchTeamNameQuery.getTeamNames(listOf(teamId1, teamId2, teamId3))

        // Then
        assertThat(result).hasSize(2)
        assertThat(result[teamId1]).isEqualTo(TeamName("KRC Genk"))
        assertThat(result[teamId2]).isNull()
        assertThat(result[teamId3]).isEqualTo(TeamName("SV Zulte-Waregem"))
    }

    @Test
    fun `getTeamNames returns empty map for empty list`() {
        // When
        val result = batchTeamNameQuery.getTeamNames(emptyList())

        // Then
        assertThat(result).isEmpty()
        verify(exactly = 0) { findTeam(any()) }
    }

    @Test
    fun `evict method exists and can be called`() {
        // Given
        val teamId = TeamId(1)

        // When/Then - should not throw exception
        batchTeamNameQuery.evict(teamId)
    }

    @Test
    fun `clearCache method exists and can be called`() {
        // When/Then - should not throw exception
        batchTeamNameQuery.clearCache()
    }
}
