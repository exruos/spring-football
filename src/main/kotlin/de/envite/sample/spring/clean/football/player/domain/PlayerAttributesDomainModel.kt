package de.envite.sample.spring.clean.football.player.domain

import de.envite.sample.spring.clean.football.types.TypedInt
import de.envite.sample.spring.clean.football.types.TypedLocalDate
import de.envite.sample.spring.clean.football.types.TypedValue
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PlayerId(value: Int) : TypedInt(value) {
    companion object {
        fun fromString(v: String) = v.toInt().let(::PlayerId)
        fun fromLong(l: Long) = l.toInt().let(::PlayerId)
    }
}

class PlayerName(value: String) : TypedValue<String>(value)

class Day(value: LocalDate) : TypedLocalDate(value) {
    companion object {
        private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        fun fromString(v: String) = LocalDateTime.parse(v, formatter).toLocalDate().let(::Day)
    }
}

class Height(value: Int) : TypedInt(value)

class Weight(value: Int) : TypedInt(value)

// wieso seither nicht als Value Object?
class PlayerApiId(value: Int) : TypedInt(value)

class PlayerFifaApiId(value: Int) : TypedInt(value)

class OverallRating(value: Int) : TypedInt(value)

class Potential(value: Int) : TypedInt(value)

enum class Foot(val value: String) {
    Right("right"),
    Left("left")
}

enum class Rate(val value: String) {
    Low("low"),
    Medium("medium"),
    High("high")
}

inline infix fun <reified E : Enum<E>, V> ((E) -> V).findBy(value: V): E? {
    return enumValues<E>().firstOrNull { this(it) == value }
}
