package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import org.springframework.context.annotation.Configuration

/**
 * Configuration for the team POJO adapter.
 * Note: Caching has been disabled for now to avoid conflicts.
 * To enable caching, add @EnableCaching annotation and ensure the cache names are registered.
 */
@Configuration
class TeamPojoConfiguration
