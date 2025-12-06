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
import org.springframework.cache.CacheManager
import org.springframework.cache.concurrent.ConcurrentMapCacheManager

internal class CachingTeamNameQueryTest {

    private val findTeam = mockk<FindTeam>()
    private lateinit var cachingTeamNameQuery: CachingTeamNameQuery
    private lateinit var cacheManager: CacheManager

    @BeforeEach
    fun setup() {
        clearMocks(findTeam)
        cacheManager = ConcurrentMapCacheManager("teamNames")
        cachingTeamNameQuery = CachingTeamNameQuery(findTeam)
    }

    @Test
    fun `getTeamName returns team name when team exists`() {
        // Given
        val teamId = TeamId(1)
        val expectedTeam = Team(
            teamId = teamId,
            name = TeamName("KRC Genk"),
            shortName = TeamShortName("GEN"),
            teamApiId = TeamApiId(9987),
            teamFifaApiId = TeamFifaApiId(673)
        )
        every { findTeam(teamId) } returns expectedTeam

        // When
        val result = cachingTeamNameQuery.getTeamName(teamId)

        // Then
        assertThat(result).isEqualTo(TeamName("KRC Genk"))
        verify(exactly = 1) { findTeam(teamId) }
    }

    @Test
    fun `getTeamName returns null when team does not exist`() {
        // Given
        val teamId = TeamId(9999)
        every { findTeam(teamId) } returns null

        // When
        val result = cachingTeamNameQuery.getTeamName(teamId)

        // Then
        assertThat(result).isNull()
        verify(exactly = 1) { findTeam(teamId) }
    }

    @Test
    fun `evict method exists and can be called`() {
        // Given
        val teamId = TeamId(1)

        // When/Then - should not throw exception
        cachingTeamNameQuery.evict(teamId)
    }

    @Test
    fun `clearCache method exists and can be called`() {
        // When/Then - should not throw exception
        cachingTeamNameQuery.clearCache()
    }
}
