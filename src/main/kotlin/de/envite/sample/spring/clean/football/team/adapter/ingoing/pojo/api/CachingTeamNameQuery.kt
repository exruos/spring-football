package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamByApiId
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
    private val findTeamByApiId: FindTeamByApiId
) : TeamNameQuery {

    @Cacheable(value = ["teamNames"], key = "#teamId")
    override fun getTeamName(teamId: Int): String {
        return findTeamByApiId(TeamApiId(teamId))?.name?.value ?: "Unknown"
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
    fun evict(teamId: Int) {
        // Cache entry will be evicted by Spring
    }
}
