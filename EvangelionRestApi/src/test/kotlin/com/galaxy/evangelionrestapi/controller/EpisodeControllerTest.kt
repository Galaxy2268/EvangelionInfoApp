package com.galaxy.evangelionrestapi.controller

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

private const val BASE_URL = "/api/episodes"
@SpringBootTest
@AutoConfigureMockMvc
internal class EpisodeControllerTest {

    @Autowired
    private lateinit var episodeController: MockMvc

    @Nested
    @DisplayName("getEpisodesEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEpisodesEndpoint {
        @Test
        fun `should return a list of episodes`() {
            episodeController.get(BASE_URL)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getEpisodeByNumberEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEpisodeByNumberEndpoint {
        @Test
        fun `should return an episode by number`() {
            episodeController.get("$BASE_URL/number/01")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.number") { value("01") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getEpisodeByIdEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEpisodeByIdEndpoint {
        @Test
        fun `should return an episode by id`() {
            episodeController.get("$BASE_URL/id/2")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.number") { value("02") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentEpisode(number)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEpisodeByNumber {
        @Test
        fun `should return is not found status`() {
            episodeController.get("$BASE_URL/number/Does not exist")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentEpisode(id)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEpisodeById {
        @Test
        fun `should return is not found status`() {
            episodeController.get("$BASE_URL/id/-1")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

}