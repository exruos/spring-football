package de.envite.sample.spring.clean.football

import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<SpringCleanFootballApplication>().with(TestcontainersConfiguration::class).run(*args)
}
