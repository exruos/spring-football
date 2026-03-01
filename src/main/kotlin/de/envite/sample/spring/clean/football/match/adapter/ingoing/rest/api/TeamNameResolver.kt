package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.match.domain.TeamId
import de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api.BatchTeamNameQuery
import de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api.CachingTeamNameQuery
import de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api.SimpleTeamNameQuery
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Component
class TeamNameResolver(
    private val properties: TeamNameResolverProperties,
    private val simpleTeamNameQuery: SimpleTeamNameQuery,
    private val cachingTeamNameQuery: CachingTeamNameQuery,
    private val batchTeamNameQuery: BatchTeamNameQuery,
    private val restClient: RestClient.Builder
) {

    private val client by lazy {
        restClient.baseUrl(properties.teamServiceBaseUrl).build()
    }

    fun resolveTeamName(teamId: TeamId): String {
        return when (properties.teamNameStrategy) {
            TeamNameStrategy.POJO_WITHOUT_CACHE -> {
                simpleTeamNameQuery.getTeamName(teamId.value)
            }
            TeamNameStrategy.POJO_WITH_CACHE -> {
                cachingTeamNameQuery.getTeamName(teamId.value)
            }
            TeamNameStrategy.POJO_BATCH_WITH_CACHE -> {
                batchTeamNameQuery.getTeamNames(listOf(teamId.value))[teamId.value] ?: "Unknown"
            }
            TeamNameStrategy.REST_CONTROLLER -> {
                @Suppress("TooGenericExceptionCaught", "SwallowedException")
                try {
                    client.get()
                        .uri("/teams/api-id/{apiId}", teamId.value)
                        .retrieve()
                        .body<TeamResponse>()
                        ?.name ?: "Unknown"
                } catch (e: Exception) {
                    // Log and swallow exception - team name resolution is not critical
                    // Returning "Unknown" allows the application to continue with missing team names
                    "Unknown"
                }
            }
        }
    }

    fun resolveTeamNames(teamIds: List<TeamId>): Map<TeamId, String> {
        return when (properties.teamNameStrategy) {
            TeamNameStrategy.POJO_BATCH_WITH_CACHE -> {
                val intTeamIds = teamIds.map { it.value }
                val teamNames = batchTeamNameQuery.getTeamNames(intTeamIds)
                teamIds.associateWith { teamId ->
                    teamNames[teamId.value] ?: "Unknown"
                }
            }
            else -> {
                teamIds.associateWith { teamId ->
                    resolveTeamName(teamId)
                }
            }
        }
    }

    private data class TeamResponse(val name: String)
}
