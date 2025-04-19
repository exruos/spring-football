package de.envite.sample.spring.clean.football.player.adapter.ingoing.grpc.api

import de.envite.sample.spring.clean.football.player.usecase.interactor.PlayerLogicConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(
    PlayerLogicConfiguration::class,
    PlayerGrpcController::class,
    EntityToGrpcResourceMapper::class
)
@Configuration
class PlayerGrpcModuleConfiguration
