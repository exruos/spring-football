package de.envite.sample.spring.clean.football.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.core.dialect.JdbcPostgresDialect

@Configuration
class DatabaseConfig {
    @Bean
    fun jdbcDialect(): JdbcPostgresDialect {
        return JdbcPostgresDialect.INSTANCE
    }
}