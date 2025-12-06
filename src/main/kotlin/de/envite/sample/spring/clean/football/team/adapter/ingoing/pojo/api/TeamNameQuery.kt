package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamName

/**
 * POJO API for querying team names by team ID.
 * This interface provides different implementations for various use cases.
 */
interface TeamNameQuery {
    /**
     * Get a team name by team ID.
     * @param teamId the ID of the team
     * @return the team name, or null if not found
     */
    fun getTeamName(teamId: TeamId): TeamName?
}
