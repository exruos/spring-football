package de.envite.sample.spring.clean.football.team.adapter.ingoing.rest.api

import de.envite.sample.spring.clean.football.team.domain.Team
import de.envite.sample.spring.clean.football.team.domain.TeamAttributes
import de.envite.sample.spring.clean.football.team.domain.TeamRecord

/**
 * Wir müssen nach Refactoring in die andere Richtung mappen.
 * Dies lässt sich nicht im Domain Model integrieren und aufgrund DataClass
 * mit parametrisierten Konstruktor auch nicht in der Resource-Klasse.
 * Ist das jetzt der Java-Way und würde man in Kotlin anders machen?
 * Wenn das auch der Kotlin-Way ist, ergibt dann das Mapping in der Resource-Klasse noch Sinn?
 * Auf der ausgehende Seite, sprich Persistenz-Adapter, funktioniert es in der DTO-Klasse.
 */
class EntityToRestResourceMapper {

    fun toTeamRecordResource(entity: TeamRecord): TeamRecordResource {
        return TeamRecordResource(
            team = this.toTeamResource(entity.team),
            attributes = entity.attributes.map { this.toTeamAttributesResource(it) }
        )
    }

    fun toTeamResource(entity: Team): TeamResource {
        return TeamResource(
            id = entity.teamId.value,
            name = entity.name.value,
            shortName = entity.shortName.value,
            apiId = entity.teamApiId.value,
            fifaApiId = entity.teamFifaApiId?.value
        )
    }

    private fun toTeamAttributesResource(entity: TeamAttributes): TeamAttributesResource {
        return TeamAttributesResource(
            date = entity.date.toString(),
            buildUpPlaySpeed = entity.buildUpPlaySpeed?.value,
            buildUpPlaySpeedClass = entity.buildUpPlaySpeedClass?.value,
            buildUpPlayDribbling = entity.buildUpPlayDribbling?.value,
            buildUpPlayDribblingClass = entity.buildUpPlayDribblingClass?.value,
            buildUpPlayPassing = entity.buildUpPlayPassing?.value,
            buildUpPlayPassingClass = entity.buildUpPlayPassingClass?.value,
            buildUpPlayPositioningClass = entity.buildUpPlayPositioningClass?.value,
            chanceCreationPassing = entity.chanceCreationPassing?.value,
            chanceCreationPassingClass = entity.chanceCreationPassingClass?.value,
            chanceCreationCrossing = entity.chanceCreationCrossing?.value,
            chanceCreationCrossingClass = entity.chanceCreationCrossingClass?.value,
            chanceCreationShooting = entity.chanceCreationShooting?.value,
            chanceCreationShootingClass = entity.chanceCreationShootingClass?.value,
            chanceCreationPositioningClass = entity.chanceCreationPositioningClass?.value,
            defencePressure = entity.defencePressure?.value,
            defencePressureClass = entity.defencePressureClass?.value,
            defenceAggression = entity.defenceAggression?.value,
            defenceAggressionClass = entity.defenceAggressionClass?.value,
            defenceTeamWidth = entity.defenceTeamWidth?.value,
            defenceTeamWidthClass = entity.defenceTeamWidthClass?.value,
            defenceDefenderLineClass = entity.defenceDefenderLineClass?.value
        )
    }
}
