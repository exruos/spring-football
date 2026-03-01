package de.envite.sample.spring.clean.football.team.adapter.ingoing.pojo.api

/**
 * POJO API for querying team names by team ID.
 * This interface provides different implementations for various use cases.
 * Uses simple types (Int, String) to avoid cross-module dependencies.
 */
interface TeamNameQuery {
    /**
     * Get a team name by team ID.
     * @param teamId the ID of the team
     * @return the team name, or "Unknown" if not found
     */
    fun getTeamName(teamId: Int): String
}
