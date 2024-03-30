package com.galaxy.evangelionrestapi.service

import com.galaxy.evangelionrestapi.web.service.EpisodeService
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class EpisodeServiceTest {

    @Autowired
    private lateinit var service: EpisodeService

    @Nested
    @DisplayName("getEpisodes")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEpisodes {
        @Test
        fun `should return a list of episodes`() {
            val episodes = service.getEpisodes()
            Assertions.assertTrue(episodes.isNotEmpty())
        }
    }

    @Nested
    @DisplayName("getEpisodeByNumber")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEpisodeByNumber {
        @Test
        fun `should return episode by number`() {
            val episode = service.getByNumber("01")
            Assertions.assertTrue(episode.number == "01")
        }
    }

    @Nested
    @DisplayName("getEpisodeByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEpisodeByPk {
        @Test
        fun `should return episode by pk`() {
            val episode = service.getByPk(2)
            Assertions.assertTrue(episode.name == "The Beast")
        }
    }

    @Nested
    @DisplayName("getNonExistentEpisode(number)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEpisodeByNumber {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByNumber("Does not exist")
            }
        }
    }

    @Nested
    @DisplayName("getNonExistentEpisode(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEpisodeByPk {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByPk(-1)
            }
        }
    }
}