package de.envite.sample.spring.clean.football.player.adapter.ingoing.grpc.api

import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.usecase.ingoing.FindPlayer
import de.envite.sample.spring.clean.football.player.usecase.ingoing.FindPlayerRecord
import de.envite.sample.spring.clean.football.proto.PlayerGrpc
import de.envite.sample.spring.clean.football.proto.PlayerIdRequest
import de.envite.sample.spring.clean.football.proto.PlayerRecordReply
import de.envite.sample.spring.clean.football.proto.PlayerReply
import io.grpc.stub.StreamObserver
import org.springframework.stereotype.Service

@Service
class PlayerGrpcController(
    private val findPlayer: FindPlayer,
    private val findPlayerRecord: FindPlayerRecord,
    private val entityToGrpcResourceMapper: EntityToGrpcResourceMapper
) : PlayerGrpc.PlayerImplBase() {
    override fun getPlayerById(request: PlayerIdRequest, responseObserver: StreamObserver<PlayerReply>) {
        val player = findPlayer(PlayerId.fromLong(request.id))
        if (player == null) {
            responseObserver.onNext(PlayerReply.newBuilder().build())
        } else {
            responseObserver.onNext(entityToGrpcResourceMapper.toPlayerReply(player))
        }
        responseObserver.onCompleted()
    }

    override fun getPlayerRecordById(request: PlayerIdRequest, responseObserver: StreamObserver<PlayerRecordReply>) {
        val playerRecord = findPlayerRecord(PlayerId.fromLong(request.id))
        if (playerRecord != null) {
            responseObserver.onNext(entityToGrpcResourceMapper.createPlayerRecordReply(playerRecord))
        } else {
            responseObserver.onNext(PlayerRecordReply.newBuilder().build())
        }
        responseObserver.onCompleted()
    }
}
