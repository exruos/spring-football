package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamName
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeam
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

/**
 * Caching implementation of TeamNameQuery using Spring's caching abstraction.
 * Results are cached to avoid repeated queries for the same team ID.
 * Requires Spring Cache to be configured in the application.
 */
@Component
class CachingTeamNameQuery(
    private val findTeam: FindTeam
) : TeamNameQuery {

    @Cacheable(value = ["teamNames"], key = "#teamId")
    override fun getTeamName(teamId: TeamId): TeamName? {
        return findTeam(teamId)?.name
    }

    /**
     * Clear the entire cache.
     * Useful for testing or when team data is known to have changed.
     */
    @CacheEvict(value = ["teamNames"], allEntries = true)
    fun clearCache() {
        // Cache will be cleared by Spring
    }

    /**
     * Clear a specific entry from the cache.
     * @param teamId the ID of the team to remove from cache
     */
    @CacheEvict(value = ["teamNames"], key = "#teamId")
    @Suppress("UnusedParameter")
    fun evict(teamId: TeamId) {
        // Cache entry will be evicted by Spring
    }
}
