package de.envite.sample.spring.clean.football.team.usecase.interactor

import de.envite.sample.spring.clean.football.team.domain.TeamId
import de.envite.sample.spring.clean.football.team.domain.TeamRecord
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeam
import de.envite.sample.spring.clean.football.team.usecase.outgoing.ReadTeamAttributes
import de.envite.sample.spring.clean.football.team.usecase.ingoing.FindTeamRecord as FindTeamRecordApi
import org.springframework.stereotype.Component

@Component
internal class FindTeamRecordInteractor(
    private val readTeam: ReadTeam,
    private val readTeamAttributes: ReadTeamAttributes
) : FindTeamRecordApi {
    override fun invoke(teamId: TeamId): TeamRecord? {
        val team = readTeam(teamId)
        if (team != null) {
            val teamAttributes = readTeamAttributes(team.teamFifaApiId, team.teamApiId)
            return TeamRecord(
                team = team,
                attributes = teamAttributes
            )
        }
        return null
    }
}
