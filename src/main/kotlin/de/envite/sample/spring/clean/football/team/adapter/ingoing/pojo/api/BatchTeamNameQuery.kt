package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamByApiId
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

/**
 * Batch implementation of team name querying with caching support.
 * Efficiently handles multiple team IDs by checking cache first and only querying
 * uncached entries. Uses Spring's caching abstraction.
 */
@Component
class BatchTeamNameQuery(
    private val findTeamByApiId: FindTeamByApiId
) {
    /**
     * Get team names for a list of team IDs.
     * Results are cached individually, so subsequent calls will benefit from the cache.
     *
     * @param teamIds the list of team IDs to query
     * @return a map of team ID to team name (includes all teams, "Unknown" if not found)
     */
    fun getTeamNames(teamIds: List<Int>): Map<Int, String> {
        return teamIds.associateWith { teamId ->
            getTeamNameCached(teamId)
        }
    }

    @Cacheable(value = ["teamNames"], key = "#teamId")
    private fun getTeamNameCached(teamId: Int): String {
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
