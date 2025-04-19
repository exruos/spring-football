package de.envite.sample.spring.clean.football.player.adapter.outgoing.persistence

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.TransactionManager
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(DataSourceProperties::class)
@EnableJdbcRepositories
class FootballDbDataSourceConfiguration : AbstractJdbcConfiguration() {

    @Bean
    @ConfigurationProperties("datasources.football.datasource")
    fun footballDbDataSourceProperties() = DataSourceProperties()

    @Bean
    @ConfigurationProperties("datasources.football.datasource.hikari")
    fun footballDbDataSource(
        footballDbDataSourceProperties: DataSourceProperties
    ): DataSource {
        val dataSource = footballDbDataSourceProperties.initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
        dataSource.poolName = "football-db"
        dataSource.validate()
        return dataSource
    }

    @Bean
    fun footballDataConnection(footballDbDataSource: DataSource): JdbcTemplate =
        JdbcTemplate(footballDbDataSource)

    @Bean
    fun footballNamedParameterJdbcTemplate(operations: JdbcOperations): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(operations)
    }

    @Bean("transactionManager")
    fun footballTransactionManager(footballDbDataSource: DataSource): TransactionManager =
        DataSourceTransactionManager(footballDbDataSource)
}
