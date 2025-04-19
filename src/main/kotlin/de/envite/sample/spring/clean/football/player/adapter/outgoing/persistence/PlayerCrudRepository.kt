package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface PlayerCrudRepository : CrudRepository<PlayerDto, Int> {
    @Query(
        """
			SELECT *
		    FROM player_attributes
			WHERE player_fifa_api_id = :player_fifa_api_id 
            AND player_api_id = :player_api_id
			"""
    )
    fun getPlayerAttributes(
        @Param("player_fifa_api_id") fifaApiId: Int,
        @Param("player_api_id") apiId: Int
    ): List<PlayerAttributesDto>
}
