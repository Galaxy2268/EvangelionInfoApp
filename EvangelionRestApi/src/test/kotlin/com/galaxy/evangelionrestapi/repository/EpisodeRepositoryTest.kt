package com.galaxy.evangelionrestapi.repository

import com.galaxy.evangelionrestapi.data.repository.EpisodeRepository
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class EpisodeRepositoryTest {

    @Autowired
    private lateinit var repository: EpisodeRepository
    @Nested
    @DisplayName("findAll")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindAll {
        @Test
        fun `should return a list of episodes`() {
            val episodes = repository.findAll()
            Assertions.assertTrue(episodes.isNotEmpty())
        }
    }


    @Nested
    @DisplayName("findByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByName {
        @Test
        fun `should return episode by number`() {
            val episode = repository.findByNumber("01")
            Assertions.assertTrue(episode?.name == "Angel Attack" && episode.number == "01")
        }
    }


    @Nested
    @DisplayName("findByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByPk {
        @Test
        fun `should return episode by pk`() {
            val episode = repository.findByPk(2)
            Assertions.assertTrue(episode?.name == "The Beast" && episode.number == "02")
        }
    }


    @Nested
    @DisplayName("findNonExistentEpisode(number)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentEpisodeByNumber{
        @Test
        fun `should return null`() {
            val episode = repository.findByNumber("Does not exist")
            Assertions.assertTrue(episode == null)
        }
    }

    @Nested
    @DisplayName("findNonExistentEpisode(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentEpisodeByPk {
        @Test
        fun `should return null`() {
            val episode = repository.findByPk(-1)
            Assertions.assertTrue(episode == null)
        }
    }
}