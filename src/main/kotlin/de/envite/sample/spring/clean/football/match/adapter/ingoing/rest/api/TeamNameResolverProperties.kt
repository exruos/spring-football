package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "match.rest")
data class TeamNameResolverProperties(
    val teamNameStrategy: TeamNameStrategy = TeamNameStrategy.POJO_WITH_CACHE,
    val teamServiceBaseUrl: String = "http://localhost:8080"
)

enum class TeamNameStrategy {
    POJO_WITHOUT_CACHE,
    POJO_WITH_CACHE,
    POJO_BATCH_WITH_CACHE,
    REST_CONTROLLER
}
