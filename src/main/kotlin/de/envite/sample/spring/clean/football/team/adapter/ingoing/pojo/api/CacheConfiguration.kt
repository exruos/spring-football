package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Cache configuration for team name queries.
 * Uses in-memory ConcurrentHashMap-based caching for simplicity.
 * Registers cache names used by @Cacheable annotations.
 */
@Configuration
@EnableCaching
class CacheConfiguration {

    /**
     * Provides a simple in-memory cache manager.
     * Supports the following cache names:
     * - "teamNames": for individual team name lookups
     */
    @Bean
    fun cacheManager(): CacheManager {
        return ConcurrentMapCacheManager("teamNames")
    }
}
