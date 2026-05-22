package de.envite.sample.spring.clean.football

import org.flywaydb.core.Flyway
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.DependsOn
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import javax.sql.DataSource

@TestConfiguration(proxyBeanMethods = false)
@Testcontainers
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> {
        return postgresContainer
    }

    @Bean(initMethod = "migrate")
    @DependsOn("postgresContainer")
    fun flyway(dataSource: DataSource): Flyway {
        return Flyway.configure()
            .dataSource(dataSource)
            .locations("classpath:test/migration")
            .load()
    }

    companion object {
        private val postgresContainer: PostgreSQLContainer<*> by lazy {
            PostgreSQLContainer(DockerImageName.parse("postgres:18.4"))
                .apply {
                    withReuse(false)
                    start()
                }
        }
    }
}
