package de.envite.sample.spring.clean.football.player.adapter.ingoing.grpc.api

import de.envite.sample.spring.clean.football.TestcontainersConfiguration
import de.envite.sample.spring.clean.football.proto.PlayerGrpc
import de.envite.sample.spring.clean.football.proto.PlayerIdRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Lazy
import org.springframework.grpc.client.GrpcChannelFactory
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@TestConfiguration
@Import(TestcontainersConfiguration::class)
class ExtraConfiguration {
    @Bean
    @Lazy
    fun stub(channels: GrpcChannelFactory, @LocalServerPort port: Int): PlayerGrpc.PlayerBlockingStub {
        return PlayerGrpc.newBlockingStub(channels.createChannel("localhost:$port"))
    }
}

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(ExtraConfiguration::class)
@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
class PlayerGrpcControllerTest(
    private val stub: PlayerGrpc.PlayerBlockingStub
) {
    @Test
    @DirtiesContext
    @Suppress("EmptyFunctionBlock")
    fun contextLoads() {
        assertThat(PlayerGrpcControllerTest::class).isNotNull
    }

    @Test
    @DirtiesContext
    internal fun `find existing player`() {
        val playerIdRequest = PlayerIdRequest.newBuilder().setId(1).build()
        val playerReply = stub.getPlayerById(playerIdRequest)
        assertThat(playerReply.playerName).isEqualTo("Aaron Appindangoye")
    }

    @Test
    @DirtiesContext
    internal fun `unknown players can be processed without an error`() {
        val playerIdRequest = PlayerIdRequest.newBuilder().setId(1111).build()
        val playerReply = stub.getPlayerById(playerIdRequest)
        assertThat(playerReply.playerName).isEqualTo("")
    }

    @Test
    @DirtiesContext
    internal fun `find player record for one player`() {
        val playerIdRequest = PlayerIdRequest.newBuilder().setId(1).build()
        val playerRecordReply = stub.getPlayerRecordById(playerIdRequest)
        assertThat(playerRecordReply.player.playerName).isEqualTo("Aaron Appindangoye")
        assertThat(playerRecordReply.attributesList.size).isEqualTo(5)
    }

    @Test
    @DirtiesContext
    internal fun `unknown players do not have a player record`() {
        val playerIdRequest = PlayerIdRequest.newBuilder().setId(1111).build()
        val playerRecordReply = stub.getPlayerRecordById(playerIdRequest)
        assertThat(playerRecordReply.player.playerName).isEqualTo("")
        assertThat(playerRecordReply.attributesList.size).isEqualTo(0)
    }
}
