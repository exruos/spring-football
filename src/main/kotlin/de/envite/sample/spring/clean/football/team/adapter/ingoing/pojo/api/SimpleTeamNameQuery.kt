package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamName
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeam
import org.springframework.stereotype.Component

/**
 * Simple implementation of TeamNameQuery that directly queries the team use case.
 * No caching is performed - each call goes to the underlying data source.
 */
@Component
class SimpleTeamNameQuery(
    private val findTeam: FindTeam
) : TeamNameQuery {
    override fun getTeamName(teamId: TeamId): TeamName? {
        return findTeam(teamId)?.name
    }
}
