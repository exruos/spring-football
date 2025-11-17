package de.envite.sample.spring.clean.football.team.domain

import de.envite.sample.spring.clean.football.types.TypedInt
import de.envite.sample.spring.clean.football.types.TypedLocalDate
import de.envite.sample.spring.clean.football.types.TypedValue
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TeamId(value: Int) : TypedInt(value) {
    companion object {
        fun fromString(v: String) = v.toInt().let(::TeamId)
        fun fromLong(l: Long) = l.toInt().let(::TeamId)
    }
}

class TeamName(value: String) : TypedValue<String>(value)

class TeamShortName(value: String) : TypedValue<String>(value)

class Day(value: LocalDate) : TypedLocalDate(value) {
    companion object {
        private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        fun fromString(v: String) = LocalDateTime.parse(v, formatter).toLocalDate().let(::Day)
    }
}

class TeamApiId(value: Int) : TypedInt(value) {
    companion object {
        fun fromString(v: String) = v.toInt().let(::TeamApiId)
    }
}

class TeamFifaApiId(value: Int) : TypedInt(value)

class BuildUpPlaySpeed(value: Int) : TypedInt(value)

class BuildUpPlayDribbling(value: Int) : TypedInt(value)

class BuildUpPlayPassing(value: Int) : TypedInt(value)

class ChanceCreationPassing(value: Int) : TypedInt(value)

class ChanceCreationCrossing(value: Int) : TypedInt(value)

class ChanceCreationShooting(value: Int) : TypedInt(value)

class DefencePressure(value: Int) : TypedInt(value)

class DefenceAggression(value: Int) : TypedInt(value)

class DefenceTeamWidth(value: Int) : TypedInt(value)

enum class PlayClass(val value: String) {
    Slow("Slow"),
    Balanced("Balanced"),
    Fast("Fast"),
    Little("Little"),
    Normal("Normal"),
    Lots("Lots"),
    Short("Short"),
    Mixed("Mixed"),
    Long("Long"),
    Risky("Risky"),
    Safe("Safe"),
    Deep("Deep"),
    Medium("Medium"),
    Press("Press"),
    Double("Double"),
    Narrow("Narrow"),
    Wide("Wide"),
    FreeForm("Free Form"),
    Organised("Organised"),
    Cover("Cover"),
    OffsideTrap("Offside Trap")
}

inline infix fun <reified E : Enum<E>, V> ((E) -> V).findBy(value: V): E? {
    return enumValues<E>().firstOrNull { this(it) == value }
}
