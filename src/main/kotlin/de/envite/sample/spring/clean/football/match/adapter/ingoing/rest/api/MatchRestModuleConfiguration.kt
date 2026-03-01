package de.envite.sample.spring.clean.football.match.adapter.ingoing.rest.api

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
@ComponentScan
@EnableConfigurationProperties(TeamNameResolverProperties::class)
class MatchRestModuleConfiguration {

    @Bean
    fun restClientBuilder(): RestClient.Builder = RestClient.builder()
}
