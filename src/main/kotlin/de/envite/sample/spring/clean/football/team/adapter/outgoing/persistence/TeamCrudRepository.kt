package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface TeamCrudRepository : CrudRepository<TeamDto, Int> {
    @Query(
        """
			SELECT *
		    FROM team_attributes
			WHERE team_fifa_api_id = :team_fifa_api_id
            AND team_api_id = :team_api_id
			"""
    )
    fun getTeamAttributes(
        @Param("team_fifa_api_id") fifaApiId: Int,
        @Param("team_api_id") apiId: Int
    ): List<TeamAttributesDto>

    @Query(
        """
			SELECT *
		    FROM team
			WHERE team_api_id = :team_api_id
			"""
    )
    fun findByTeamApiId(@Param("team_api_id") apiId: Int): TeamDto?

    @Query(
        """
			SELECT *
		    FROM team
			WHERE team_api_id IN (:team_api_ids)
			"""
    )
    fun findByTeamApiIdIn(@Param("team_api_ids") apiIds: List<Int>): List<TeamDto>
}
