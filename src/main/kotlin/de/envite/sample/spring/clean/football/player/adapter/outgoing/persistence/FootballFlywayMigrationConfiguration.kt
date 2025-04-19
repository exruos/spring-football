package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.flyway.FlywayProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(FlywayProperties::class)
class FootballFlywayMigrationConfiguration {
    @Bean
    @ConfigurationProperties("datasources.flyway")
    fun flywayProperties() = FlywayProperties()

    @Bean
    fun flywayMigrationInitializer(
        flywayProperties: FlywayProperties,
        footballDbDataSource: DataSource
    ): InitializingBean = InitializingBean {
        Flyway.configure()
            .dataSource(footballDbDataSource)
            .locations(flywayProperties.locations.first())
            .table("flyway_schema_history")
            .load()
            .migrate()
    }
}
