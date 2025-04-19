package de.envite.sample.spring.clean.football.player.usecase.interactor

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    FindPlayerInteractor::class,
    FindPlayerRecordInteractor::class
)
@Configuration
class PlayerLogicConfiguration
