package de.envite.sample.spring.clean.football

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> {
        return postgresContainer
    }

    companion object {
        private val postgresContainer: PostgreSQLContainer<*> by lazy {
            PostgreSQLContainer(DockerImageName.parse("postgres:17.5"))
                .apply {
                    withReuse(false)
                    start()
                }
        }
    }
}
