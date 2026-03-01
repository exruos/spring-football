package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.TeamApiId
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamByApiId
import org.springframework.stereotype.Component

/**
 * Simple implementation of TeamNameQuery that directly queries the team use case.
 * No caching is performed - each call goes to the underlying data source.
 */
@Component
class SimpleTeamNameQuery(
    private val findTeamByApiId: FindTeamByApiId
) : TeamNameQuery {
    override fun getTeamName(teamId: Int): String {
        return findTeamByApiId(TeamApiId(teamId))?.name?.value ?: "Unknown"
    }
}
