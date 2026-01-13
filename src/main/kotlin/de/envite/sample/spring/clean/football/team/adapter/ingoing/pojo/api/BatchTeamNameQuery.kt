package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamsByApiIds
import org.springframework.cache.CacheManager
import org.springframework.stereotype.Component

/**
 * Batch implementation of team name querying with optimized caching support.
 * Efficiently handles multiple team IDs by:
 * 1. Checking cache first for all requested IDs
 * 2. Making a SINGLE batch query for all uncached IDs
 * 3. Caching the results for future requests
 *
 * This approach eliminates the N+1 query problem for cache misses.
 */
@Component
class BatchTeamNameQuery(
    private val findTeamsByApiIds: FindTeamsByApiIds,
    private val cacheManager: CacheManager
) {
    companion object {
        private const val CACHE_NAME = "teamNames"
    }

    private val cache by lazy {
        cacheManager.getCache(CACHE_NAME)
            ?: error("Cache '$CACHE_NAME' not configured")
    }

    /**
     * Get team names for a list of team IDs.
     * Results are cached individually, so subsequent calls will benefit from the cache.
     *
     * Algorithm:
     * 1. Check which team IDs are already in cache
     * 2. For uncached IDs, make ONE batch database query
     * 3. Cache all newly fetched results
     * 4. Return combined results (cached + newly fetched)
     *
     * @param teamIds the list of team IDs to query
     * @return a map of team ID to team name (includes all teams, "Unknown" if not found)
     */
    fun getTeamNames(teamIds: List<Int>): Map<Int, String> {
        if (teamIds.isEmpty()) {
            return emptyMap()
        }

        // Step 1: Separate cached and uncached IDs
        val cachedResults = mutableMapOf<Int, String>()
        val uncachedIds = mutableListOf<Int>()

        for (teamId in teamIds) {
            val cachedValue = cache.get(teamId, String::class.java)
            if (cachedValue != null) {
                cachedResults[teamId] = cachedValue
            } else {
                uncachedIds.add(teamId)
            }
        }

        // Step 2: If there are uncached IDs, fetch them in ONE batch query
        val batchResults = if (uncachedIds.isNotEmpty()) {
            val teamApiIds = uncachedIds.map { TeamApiId(it) }
            val teams = findTeamsByApiIds(teamApiIds)

            // Create map of found teams
            val foundTeams = teams.associate { team ->
                team.teamApiId.value to team.name.value
            }

            // Step 3: Cache all results (including "Unknown" for not found teams)
            uncachedIds.associateWith { teamId ->
                val teamName = foundTeams[teamId] ?: "Unknown"
                cache.put(teamId, teamName)
                teamName
            }
        } else {
            emptyMap()
        }

        // Step 4: Combine cached and newly fetched results
        return cachedResults + batchResults
    }

    /**
     * Clear the entire cache.
     * Useful for testing or when team data is known to have changed.
     */
    fun clearCache() {
        cache.clear()
    }

    /**
     * Clear a specific entry from the cache.
     * @param teamId the ID of the team to remove from cache
     */
    fun evict(teamId: Int) {
        cache.evict(teamId)
    }
}
