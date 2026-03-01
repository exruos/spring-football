package de.envite.sample.spring.clean.football

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.modulith.Modulithic

@Modulithic(sharedModules = ["types"])
@SpringBootApplication
class SpringCleanFootballApplication

fun main(args: Array<String>) {
    runApplication<SpringCleanFootballApplication>(args = args)
}
