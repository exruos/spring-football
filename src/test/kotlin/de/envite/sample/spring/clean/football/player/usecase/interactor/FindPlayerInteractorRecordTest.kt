package de.envite.sample.spring.clean.football.player.usecase.interactor

import de.envite.sample.spring.clean.football.TestcontainersConfiguration
import de.envite.sample.spring.clean.football.player.domain.PlayerId
import de.envite.sample.spring.clean.football.player.domain.PlayerName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import kotlin.test.assertFails

@SpringBootTest()
@ActiveProfiles("test")
@Import(TestcontainersConfiguration::class)
@TestConstructor(autowireMode = ALL)
internal class FindPlayerInteractorRecordTest(
    val getPlayerRecord: FindPlayerRecordInteractor,
) {
    @Test
    fun `find record for existing player`() {
        val record = getPlayerRecord(PlayerId(1))
        if (record != null) {
            assertThat(record).isNotNull
            assertThat(record.player.name).isEqualTo(PlayerName("Aaron Appindangoye"))
            assertThat(record.attributes.size).isEqualTo(5)
        } else {
            assertFails { }
        }
    }

    @Test
    fun `record must be null for non-existing player`() {
        val record = getPlayerRecord(PlayerId(666))
        assertThat(record).isNull()
    }
}
