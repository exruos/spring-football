package de.envite.sample.spring.clean.football.team.adapter.outgoing.persistence

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.TransactionManager
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(DataSourceProperties::class)
class TeamDbDataSourceConfiguration : AbstractJdbcConfiguration() {

    @Bean
    @ConfigurationProperties("datasources.team.datasource")
    fun teamDbDataSourceProperties() = DataSourceProperties()

    @Bean
    @ConfigurationProperties("datasources.team.datasource.hikari")
    fun teamDbDataSource(
        teamDbDataSourceProperties: DataSourceProperties
    ): DataSource {
        val dataSource = teamDbDataSourceProperties.initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
        dataSource.poolName = "team-db"
        dataSource.validate()
        return dataSource
    }

    @Bean
    fun teamDataConnection(teamDbDataSource: DataSource): JdbcTemplate =
        JdbcTemplate(teamDbDataSource)

    @Bean
    fun teamNamedParameterJdbcTemplate(operations: JdbcOperations): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(operations)
    }

    @Bean("teamTransactionManager")
    fun teamTransactionManager(teamDbDataSource: DataSource): TransactionManager =
        DataSourceTransactionManager(teamDbDataSource)
}
