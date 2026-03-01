package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.testcontainers.junit.jupiter.Testcontainers

@ApplicationModuleTest
@ActiveProfiles("test")
@Testcontainers
@TestConstructor(autowireMode = ALL)
internal class TeamCrudRepositoryTest(
    private val teamCrudRepository: TeamCrudRepository
) {
    @Test
    fun findSingleTeam() {
        val team = teamCrudRepository.findById(1).get()
        assertThat(team).isNotNull
        assertThat(team.teamLongName).isEqualTo("KRC Genk")
        assertThat(team.teamShortName).isEqualTo("GEN")
    }

    @Test
    fun findTeamAttributes() {
        val team = teamCrudRepository.findById(1).get()
        assertThat(team).isNotNull
        assertThat(team.teamFifaApiId).isNotNull
        val teamAttributes = teamCrudRepository.getTeamAttributes(team.teamFifaApiId!!, team.teamApiId)
        assertThat(teamAttributes.size).isGreaterThan(0)
    }

    @Test
    fun findTeamByApiId() {
        val team = teamCrudRepository.findByTeamApiId(9987)
        assertThat(team).isNotNull
        assertThat(team?.teamLongName).isEqualTo("KRC Genk")
        assertThat(team?.teamShortName).isEqualTo("GEN")
        assertThat(team?.teamApiId).isEqualTo(9987)
    }

    @Test
    fun findTeamByUnknownApiId() {
        val team = teamCrudRepository.findByTeamApiId(99999)
        assertThat(team).isNull()
    }
}
